package com.qudian.pay.ares.controller;

import com.alibaba.fastjson.JSONObject;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.enumeration.TaskTypeEnum;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.vo.TaskInfoVo;
import com.qudian.pay.ares.service.TaskService;
import com.qudian.pay.ares.service.TransferService;
import com.qudian.pay.ares.service.common.Constant;
import com.qudian.pay.ares.service.impl.TransferServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.qudian.pay.ares.service.common.Constant.taskInfo.task_status_faile;

/**
 * Created by zhangdelong on 17/1/16.
 */
@Controller
@RequestMapping("/remedy")
public class RemedyController {
    private static Logger logger = LoggerFactory.getLogger(RemedyController.class);
    @Resource
    TransferService transferService;
    @Resource
    TaskService taskService;

    //补单Controller
    @RequestMapping(value = "/bondTransfer")
    @ResponseBody
    public JSONObject bondTransfer(HttpServletRequest request, String sdate, String edate, int loanArea) {
        JSONObject jsonObject = new JSONObject();
        try {
            if (DateUtil.dayDiff(sdate, edate) < 0) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "开始时间不能小于结束时间!");
                return jsonObject;
            }
            if (DateUtil.dayDiff(sdate, edate) > 31) {
                jsonObject.put("code", 1);
                jsonObject.put("msg", "开始时间和结束时间不能相差大于31天!");
                return jsonObject;
            }

            jsonObject = transferService.paramsAnalysis(request, sdate, edate, Integer.valueOf(TaskTypeEnum.HANDER.getCode()), loanArea);
        } catch (Exception e) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "未知异常");
            logger.error("bondTransfer() 补单Controller 异常", e);
            e.printStackTrace();
            return jsonObject;
        }

        return jsonObject;
    }

    @RequestMapping(value = "/queryList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getList(TaskInfo taskInfo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("remedy->queryList 传参,{}", taskInfo);
        // TaskInfo taskInfo = new TaskInfo();
        JSONObject jsonObject = new JSONObject();
        //String status = request.getParameter("status");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("rows");
        int startLimit = 1;
        int endLimit = 0;
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        startLimit = Integer.parseInt(page);
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = "31";
        }
        endLimit = Integer.parseInt(pageSize);
        // taskInfo.setTaskStatus(Integer.valueOf(status));
        PageInfoPO<TaskInfo> taskInfoPageInfoPO = taskService.queryByPage(taskInfo, startLimit, endLimit);
        int totalPage = (taskInfoPageInfoPO.getCount() + Integer.valueOf(pageSize) - 1) / Integer.valueOf(pageSize);
        jsonObject.put("rows", taskInfoPageInfoPO.getResults());
        jsonObject.put("page", page);
        jsonObject.put("total", totalPage);
        jsonObject.put("records", taskInfoPageInfoPO.getCount());
        return jsonObject;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public JSONObject update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String str = null;
        Integer id = Integer.valueOf(request.getParameter("id"));
        logger.info("remedy->update() Controller 被调用,传入id{},", id);
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setId(id);
        taskInfo.setTaskStatus(Constant.taskInfo.task_status_faile);
        int count = taskService.update(taskInfo);
        if (count > 0) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "操作成功");
        } else {
            jsonObject.put("code", -1);
            jsonObject.put("msg", "操作失败,可能没有找到此id," + id);
        }
        return jsonObject;
    }
}
