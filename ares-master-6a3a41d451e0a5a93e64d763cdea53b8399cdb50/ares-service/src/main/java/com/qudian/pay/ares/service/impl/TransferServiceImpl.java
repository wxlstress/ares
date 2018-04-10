package com.qudian.pay.ares.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qudian.pay.ares.dao.entity.laifenqi.BillItems;
import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.enumeration.TaskNameEnum;
import com.qudian.pay.ares.dao.enumeration.TaskStatusEnum;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.*;
import com.qudian.pay.ares.service.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.qudian.pay.ares.dao.vo.CsvVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangdelong on 17/1/15.
 */
@Service
public class TransferServiceImpl implements TransferService {
    //初始化一个线程池  // 定义成全局的
    ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);

    private static final Integer TASK_SIZE = 10000;
    @Resource
    private TaskService taskService;
    @Resource
    private BaseOrderService baseOrderService;
    @Resource
    private BilltemService billtemService;


    /**
     * @param beginDate
     * @param endDate
     * @param loanArea
     * @return
     */

    @Override
    public JSONObject paramsAnalysis(HttpServletRequest request, String beginDate, String endDate, Integer taskType, int loanArea) throws Exception {

        logger.info("调用-->remedy>bondTransfer()方法,入参数,开始时间,{},结束时间,{},type{},", beginDate, endDate, loanArea);
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(beginDate);
        Date dEnd = sdf.parse(endDate);
        List<Date> lDate = DateUtil.getDateRange(dBegin, dEnd);
        String initDate = null;
        String delDate = null;
        String remsg = null;
        for (Date date : lDate) {
            //  System.out.println(sdf.format(date));

            //判断当前状态{初始化,补单时间,任务类型} 是否有正在执行的任务,有的话则跳过
            TaskInfo tmpTask = new TaskInfo();
            tmpTask.setRepairDate(date);
            tmpTask.setTaskStatus(Integer.valueOf(TaskStatusEnum.TASK_INIT.getCode()));
            tmpTask.setTaskName(TaskNameEnum.getNameByCode(String.valueOf(loanArea)));
            tmpTask.setTaskType(taskType);
            List<TaskInfo> taskQuery = taskService.query(tmpTask);
            if (ObjectUtil.isNotEmpty(taskQuery)) {
                //logger.info("任务id,{},正在初始化,已跳过", taskQuery.get(0).getId());
                if (initDate != null) {
                    initDate = initDate + "," + DateUtil.formatToDay2(date);
                } else {
                    initDate = DateUtil.formatToDay2(date);
                }
                continue;
            }
            //判断当前状态{已完成,补单时间,任务类型} 是否有执行完的任务,有的话则删除;
            TaskInfo tmpTask1 = new TaskInfo();
            tmpTask1.setRepairDate(date);
            tmpTask1.setTaskStatus(Integer.valueOf(TaskStatusEnum.TASK_DONE.getCode()));
            //tmpTask1.setTaskType(taskType);
            tmpTask1.setTaskName(TaskNameEnum.getNameByCode(String.valueOf(loanArea)));
            List<TaskInfo> taskQuery1 = taskService.query(tmpTask1);
            if (ObjectUtil.isNotEmpty(taskQuery1)) {
                for (TaskInfo t : taskQuery1) {
                    TaskInfo record = new TaskInfo();
                    record.setId(t.getId());
                    taskService.delete(record);
                }
                //logger.info("任务id,{},被删除", taskQuery1.get(0).getId());
                if (delDate != null) {
                    delDate = delDate + "," + DateUtil.formatToDay2(date);
                } else {
                    delDate = DateUtil.formatToDay2(date);
                }
            }

            TaskInfo taskInfo = new TaskInfo();
            taskInfo.setCreateTime(new Date());
            taskInfo.setTaskStatus(Integer.valueOf(TaskStatusEnum.TASK_INIT.getCode()));
            taskInfo.setTaskName(TaskNameEnum.getNameByCode(String.valueOf(loanArea)));
            taskInfo.setTaskType(taskType);
            taskInfo.setRepairDate(date);
            if (ObjectUtil.isNotEmpty(request)) {
                taskInfo.setOperateUserId(Integer.valueOf(request.getParameter("userId")));
                taskInfo.setOperateUser(request.getParameter("username"));
            }
            int taskId = taskService.insertReturnPK(taskInfo);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Date sd = DateUtil.getCurrentDayStartTime(cal.getTime());
            Date ed = DateUtil.getCurrentDayEndTime(cal.getTime());
            BondTransferAsynThread bondTransferAsynThread = new BondTransferAsynThread(sd, ed, taskId, loanArea);
            es.submit(bondTransferAsynThread);
        }
        jsonObject.put("code", 1);
        if (initDate != null) {
            remsg = "应还日期" + initDate + "正在执行,程序已跳过";
            //jsonObject.put("msg", "任务已提交,应还日期" + initDate + "正在执行,程序已跳过");
        }
        if (delDate != null) {
            if (remsg != null) {
                remsg = remsg + "," + "应还日期" + delDate + "程序已执行过,相关记录已删除,将重新执行";
            } else {
                remsg = "应还日期" + delDate + "程序已执行过,相关记录已删除,将重新执行";
            }
        }

        if (initDate == null && delDate == null) {
            jsonObject.put("msg", "任务已提交,页面将返回,请等待执行结果");
        } else {
            logger.info("remsg,{}", remsg);
            jsonObject.put("msg", "任务已提交,请等待执行结果," + remsg);
        }

        logger.info(jsonObject.toString());
        return jsonObject;
    }

    class BondTransferAsynThread implements Callable<String> {
        private Date beginDate;
        private Date endDate;
        private int taskId;
        private int loanArea;

        public BondTransferAsynThread(Date beginDate, Date endDate, int taskId, int loanArea) {
            this.beginDate = beginDate;
            this.endDate = endDate;
            this.taskId = taskId;
            this.loanArea = loanArea;
        }

        @Override
        public String call() throws Exception {
            if (loanArea == 0) {
                bondTransfer(beginDate, endDate, taskId, loanArea);
            } else {
                wjsBondTransfer(beginDate, endDate, taskId, loanArea);
            }
            return null;
        }
    }


    @Override
    public void bondTransfer(Date beginDate, Date endDate, int taskId, int loanArea) throws Exception {
        logger.info("TransferServiceImpl-->bondTransfer()参数接口被调用,传入参数,开始时间,{},结束时间,{},类型,{}", beginDate, endDate);
        List<CsvVO> csvVOList = new ArrayList<>();
        BaseOrderId record = new BaseOrderId();
        int orderSize = baseOrderService.count(record);
        //int orderSize = 400000;
        logger.info("订单ID共{}条", orderSize);
        //分页查询
        int size = orderSize % TASK_SIZE == 0 ? orderSize / TASK_SIZE : orderSize / TASK_SIZE + 1;
        try {
            for (int i = 0; i <= size - 1; i++) {
                int begin = (i * TASK_SIZE);
                logger.info("当前分页, begin,{},end,{}", begin, TASK_SIZE);
                BaseOrderId baseOrderId = new BaseOrderId();
                PageInfoPO<BaseOrderId> baseOrderIdPageInfoPO = baseOrderService.queryByPage(baseOrderId, begin, TASK_SIZE);
                List<BillItems> billItemsList = billtemService.queryByList(baseOrderIdPageInfoPO.getResults(), beginDate, endDate);
                csvVOList.addAll(billtemService.bondTransfer(billItemsList, taskId, loanArea));
            }
            if (!CollectionUtils.isEmpty(csvVOList)) {//可以无真实还款，避免上传空文件
                billtemService.toFtp(taskId, csvVOList, loanArea, beginDate);
            } else {//把任务状态改为成功
                TaskInfo recordTmp = new TaskInfo();
                recordTmp.setId(taskId);
                recordTmp.setTaskStatus(Constant.taskInfo.task_status_done);
                recordTmp.setErrorMsg("无真实还款");
                recordTmp.setUpdateTime(new Date());
                taskService.updateByExample(recordTmp);
            }

        } catch (Exception e) {
            logger.error("TransferServiceImpl-->bondTransfer(){服务异常}", e.getMessage());
            TaskInfo task = new TaskInfo();
            task.setId(taskId);
            task.setErrorMsg(Constant.taskInfo.FAILE_MSG);
            task.setTaskStatus(Constant.taskInfo.task_status_faile);
            task.setErrorDetailedMsg(e.getMessage());
            task.setUpdateTime(new Date());
            taskService.updateByExample(task);
            e.printStackTrace();
        }
    }

    @Override
    public void wjsBondTransfer(Date beginDate, Date endDate, int taskId, int loanArea) {
        logger.info("TransferServiceImpl-->wjsBondTransfer()参数接口被调用,传入参数,开始时间,{},结束时间,{},类型,{},系统类型,{},任务id,{}", beginDate, endDate, loanArea, taskId);
        List<CsvVO> csvVOList = new ArrayList<>();
        int orderSize = billtemService.countByOrdersAndbillItems(beginDate, endDate, loanArea);
        logger.info("订单ID共{}条", orderSize);
        int size = orderSize % TASK_SIZE == 0 ? orderSize / TASK_SIZE : orderSize / TASK_SIZE + 1;
        try {
            for (int i = 0; i <= size - 1; i++) {
                int begin = (i * TASK_SIZE);
                logger.info("当前分页, begin,{},TASK_SIZE,{}", begin, TASK_SIZE);
                PageInfoPO<BillItems> billItems = billtemService.queryOrdersAndbillItems(beginDate, endDate, begin, TASK_SIZE, loanArea);
                csvVOList.addAll(billtemService.bondTransfer(billItems.getResults(), taskId, loanArea));
            }
            if (!CollectionUtils.isEmpty(csvVOList)) {//可以无真实还款，避免上传空文件
                billtemService.toFtp(taskId, csvVOList, loanArea, beginDate);
            } else {//把任务状态改为成功
                TaskInfo recordTmp = new TaskInfo();
                recordTmp.setId(taskId);
                recordTmp.setTaskStatus(Constant.taskInfo.task_status_done);
                recordTmp.setErrorMsg("无真实还款");
                recordTmp.setUpdateTime(new Date());
                taskService.updateByExample(recordTmp);
            }
        } catch (Exception e) {
            logger.error("TransferServiceImpl-->wjsBondTransfer(),服务异常,{}", e);
            TaskInfo task = new TaskInfo();
            task.setId(taskId);
            task.setErrorMsg(Constant.taskInfo.FAILE_MSG);
            task.setTaskStatus(Constant.taskInfo.task_status_faile);
            task.setErrorDetailedMsg(e.getMessage());
            task.setUpdateTime(new Date());
            taskService.updateByExample(task);
            e.printStackTrace();
        }
    }
}
