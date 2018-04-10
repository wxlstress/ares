package com.qudian.pay.ares.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.qudian.pay.ares.dao.dto.FinancingCostVo;
import com.qudian.pay.ares.dao.entity.local.FinancingCost;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.FinancingService;
import com.qudian.pay.ares.service.utils.CaculateUtil;
import com.qudian.pay.ares.service.utils.ExcelDataFormatter;
import com.qudian.pay.ares.service.utils.ExcelUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//融资成本维护
@Controller
@RequestMapping("/financing")
public class FinancingController {
    private static Logger logger = LoggerFactory.getLogger(FinancingController.class);

    @Resource
    FinancingService financingService;


    @SuppressWarnings("rawtypes")
    /**
     * 等额本息计算获取还款方式为等额本息的每月偿还利息
     * financingCostVo
     *
     * @param financingCostVo.getLoanCapital() 总借款额（贷款本金）
     * @param financingCostVo.getRepayRate()   年利率
     * @param financingCostVo.getTerm()        还款总月数
     * @param financingCostVo.getTermNumber()  当前的期数
     * @return 当前期数偿还的利息
     */
    @RequestMapping(value = "/equalPrincipalAndInterest")
    @ResponseBody
    public JSONObject equalPrincipalAndInterest(FinancingCostVo financingCostVo) {
        logger.info("rawtypes->equalPrincipalAndInterest 被调用,入参" + financingCostVo);
        JSONObject jsonObject = new JSONObject();

        try {
            if (financingCostVo.getRepayMethod() == 0) {
                Map<Integer, BigDecimal> map = CaculateUtil.getPerMonthInterest(financingCostVo.getLoanCapital().doubleValue(), financingCostVo.getRepayRate().divide(new BigDecimal("100")).doubleValue(), financingCostVo.getTerm(), BigDecimal.ROUND_HALF_UP);
                //所有的应还本金
                Map<Integer, BigDecimal> captialMap = CaculateUtil.getPerMonthPrincipal(financingCostVo.getLoanCapital().doubleValue(), financingCostVo.getRepayRate().divide(new BigDecimal("100")).doubleValue(), financingCostVo.getTerm(), BigDecimal.ROUND_HALF_UP);
                BigDecimal cap = new BigDecimal("0.00");
                for (Map.Entry<Integer, BigDecimal> entry : captialMap.entrySet()) {
                    if (entry.getKey() > financingCostVo.getTermNumber().intValue()) {
                        break;
                    } else {
                        cap = cap.add(entry.getValue());
                    }
                }

                jsonObject.put("money", map.get((int) financingCostVo.getTermNumber()));

                if ((int) financingCostVo.getTermNumber() == (int) financingCostVo.getTerm()) {
                    jsonObject.put("shengyu", 0);
                } else {
                    jsonObject.put("shengyu", financingCostVo.getLoanCapital().subtract(cap));
                }
            } else {
                jsonObject.put("shengyu", 0);
                //放款本金*还款利率
                BigDecimal b1 = financingCostVo.getLoanCapital().multiply(financingCostVo.getRepayRate().divide(new BigDecimal("100")));
                // / 365*
                BigDecimal b2 = b1.divide(new BigDecimal("365"), 5, BigDecimal.ROUND_HALF_UP);
                //还款日-放款日-1
                int num = DateUtil.dayDiff(financingCostVo.getLoanDayStr(), financingCostVo.getRepayDayStr());
                BigDecimal b3 = b2.multiply(BigDecimal.valueOf(num));
                jsonObject.put("money", b3);
            }
        } catch (Exception e) {
            jsonObject.put("-1", "操作失败" + e);
            logger.error("financing->equalPrincipalAndInterest()方法异常", e);
            e.printStackTrace();
        }

        return jsonObject;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public JSONObject add(FinancingCostVo financingCostVo) {
        logger.info("rawtypes->add 被调用,入参" + financingCostVo);

        JSONObject jsonObject = new JSONObject();
        try {
//            BeanUtilsBean.getInstance().getConvertUtils()
//                    .register(new DateConverter(null), Date.class);
            FinancingCost financingCost = new FinancingCost();
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelType())) {
                financingCost.setChannelType(financingCostVo.getChannelType());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelId())) {
                financingCost.setChannelId(financingCostVo.getChannelId());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelClassified())) {
                financingCost.setChannelClassified(financingCostVo.getChannelClassified());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRepayMethod())) {
                financingCost.setRepayMethod(financingCostVo.getRepayMethod());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRepayRate())) {
                financingCost.setRepayRate(financingCostVo.getRepayRate());
            } else {
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "还款利率  不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getLoanDayStr())) {
                financingCost.setLoanDay(DateUtil.stringDateToDate2(financingCostVo.getLoanDayStr()));
            } else {
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "放款日不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRepayDayStr())) {
                financingCost.setRepayDay(DateUtil.stringDateToDate2(financingCostVo.getRepayDayStr()));
            } else {
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "还款日不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getInterestType())) {
                financingCost.setInterestType(financingCostVo.getInterestType());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getTerm())) {
                financingCost.setTerm(financingCostVo.getTerm());
            } else {
                //期限
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "期限不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getTermNumber())) {
                financingCost.setTermNumber(financingCostVo.getTermNumber());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getLoanCapital())) {
                financingCost.setLoanCapital(financingCostVo.getLoanCapital());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getYinghuanLixi())) {
                financingCost.setYinghuanLixi(financingCostVo.getYinghuanLixi());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getShengyuCapital())) {
                financingCost.setShengyuCapital(financingCostVo.getShengyuCapital());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getOtherCost())) {
                financingCost.setOtherCost(financingCostVo.getOtherCost());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getOtherCost())) {
                financingCost.setOtherCost(financingCostVo.getOtherCost());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRemark())) {
                financingCost.setRemark(financingCostVo.getRemark());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelName())) {
                financingCost.setChannelName(financingCostVo.getChannelName());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getOptUser())) {
                financingCost.setOptUser(financingCostVo.getOptUser());
            }

            financingCost.setCreateTime(new Date());
            financingCost.setUpdateTime(new Date());
            financingCost.setExt1("0");
            financingService.insert(financingCost);

            jsonObject.put("code", "1");
            jsonObject.put("msg", "操作成功");
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "操作失败" + e);
            logger.error("financing->add()方法异常", e);
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping(value = "/queryList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject getList(FinancingCostVo financingCostVo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        //String status = request.getParameter("status");
        logger.info("rawtypes->queryList 被调用,入参" + financingCostVo);


        FinancingCost f = new FinancingCost();
        if (financingCostVo.getChannelClassified() != null)
            f.setChannelClassified(financingCostVo.getChannelClassified());

        if (financingCostVo.getChannelType() != null)
            f.setChannelType(financingCostVo.getChannelType());

        if (financingCostVo.getChannelName() != null)
            f.setChannelName(financingCostVo.getChannelName());

        if (financingCostVo.getChannelId() != null)
            f.setChannelId(financingCostVo.getChannelId());

        if (financingCostVo.getCreateTime() != null)
            f.setCreateTime(financingCostVo.getCreateTime());
        if (financingCostVo.getRepayMethod() != null) {
            f.setRepayMethod(financingCostVo.getRepayMethod());
        }

        if (financingCostVo.getChannelName()!=null){
            f.setChannelName(financingCostVo.getChannelName());
        }
        if (financingCostVo.getExt1()!=null){
            f.setExt1(financingCostVo.getExt1());
        }

        String page = request.getParameter("page");
        String pageSize = request.getParameter("rows");
        int startLimit = 1;
        int endLimit = 0;
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        startLimit = Integer.parseInt(page);
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = "10";
        }

        endLimit = Integer.parseInt(pageSize);
        PageInfoPO<FinancingCost> taskInfoPageInfoPO = financingService.queryByPage(f, startLimit, endLimit);

        int totalPage = (taskInfoPageInfoPO.getCount() + Integer.valueOf(pageSize) - 1) / Integer.valueOf(pageSize);
        jsonObject.put("rows", taskInfoPageInfoPO.getResults());
        jsonObject.put("page", page);
        jsonObject.put("total", totalPage);
        jsonObject.put("records", taskInfoPageInfoPO.getCount());
        return jsonObject;
    }

    @RequestMapping(value = "/queryById", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject selectByPrimaryKey(Integer id) {
        logger.info("rawtypes->queryById 被调用,入参" + id);

        JSONObject jsonObject = new JSONObject();
        FinancingCost financingCost = financingService.selectByPrimaryKey(id);
        financingCost.setLoanDayStr(DateUtil.formatToDay2(financingCost.getLoanDay()));
        financingCost.setRepayDayStr(DateUtil.formatToDay2(financingCost.getRepayDay()));
        return (JSONObject) JSON.toJSON(financingCost);
    }

    //    @RequestMapping(value = "/update")
//    @ResponseBody
//    @ToJsonObject
//    public JSONObject update(FinancingCostVo financingCostVo,FinancingCost financingCost,JSONObject jsonObject){
//        financingService.update(financingCost);
//        return jsonObject;
//    }
    @RequestMapping(value = "/update")
    @ResponseBody
    public JSONObject update(FinancingCostVo financingCostVo) {
        logger.info("rawtypes->update 被调用,入参" + financingCostVo);

        JSONObject jsonObject = new JSONObject();
        try {
            FinancingCost financingCost = new FinancingCost();
            // BeanUtils.copyProperties(financingCost, financingCostVo);
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelType())) {
                financingCost.setChannelType(financingCostVo.getChannelType());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelId())) {
                financingCost.setChannelId(financingCostVo.getChannelId());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelClassified())) {
                financingCost.setChannelClassified(financingCostVo.getChannelClassified());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRepayMethod())) {
                financingCost.setRepayMethod(financingCostVo.getRepayMethod());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRepayRate())) {
                financingCost.setRepayRate(financingCostVo.getRepayRate());
            } else {
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "还款利率  不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getLoanDayStr())) {
                financingCost.setLoanDay(DateUtil.stringDateToDate2(financingCostVo.getLoanDayStr()));
            } else {
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "放款日不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRepayDayStr())) {
                financingCost.setRepayDay(DateUtil.stringDateToDate2(financingCostVo.getRepayDayStr()));
            } else {
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "还款日不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getInterestType())) {
                financingCost.setInterestType(financingCostVo.getInterestType());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getTerm())) {
                financingCost.setTerm(financingCostVo.getTerm());
            } else {
                //期限
                jsonObject.put("code", "-1");
                jsonObject.put("msg", "期限不能为空");
                return jsonObject;
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getTermNumber())) {
                financingCost.setTermNumber(financingCostVo.getTermNumber());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getLoanCapital())) {
                financingCost.setLoanCapital(financingCostVo.getLoanCapital());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getYinghuanLixi())) {
                financingCost.setYinghuanLixi(financingCostVo.getYinghuanLixi());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getShengyuCapital())) {
                financingCost.setShengyuCapital(financingCostVo.getShengyuCapital());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getOtherCost())) {
                financingCost.setOtherCost(financingCostVo.getOtherCost());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getOtherCost())) {
                financingCost.setOtherCost(financingCostVo.getOtherCost());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getRemark())) {
                financingCost.setRemark(financingCostVo.getRemark());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getChannelName())) {
                financingCost.setChannelName(financingCostVo.getChannelName());
            }
            if (ObjectUtil.isNotEmpty(financingCostVo.getOptUser())) {
                financingCost.setOptUser(financingCostVo.getOptUser());
            }
            financingCost.setId(financingCostVo.getId());
            financingCost.setCreateTime(new Date());
            financingCost.setUpdateTime(new Date());
            financingService.update(financingCost);
            jsonObject.put("code", "1");
            jsonObject.put("msg", "操作成功");
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "操作失败" + e);
            logger.error("financing->add()方法异常", e);
            e.printStackTrace();
            return jsonObject;
        }
        return jsonObject;
    }


    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public JSONObject updateStatus(String ids,String type,String operUser) {
        logger.info("rawtypes->update 被调用,入参" + ids+"operUser:"+operUser);
        JSONObject jsonObject = new JSONObject();
        try {
            if(StringUtils.isEmpty(ids)){
               return jsonObject;
            }
            String[] split = ids.split(",");
            FinancingCost financingCost = new FinancingCost();
            for (int i=0;i<split.length;i++){
                //设置为已审核 1
                if("audit".equals(type)||"auditAll".equals(type)){
                    financingCost.setExt1("1");
                }else if ("del".equals(type)){
                    financingCost.setExt1("0");
                }
                financingCost.setId(Integer.valueOf(split[i]));
                financingCost.setOptUser(operUser);
                financingService.update(financingCost);
            }
            jsonObject.put("code", "1");
            jsonObject.put("msg", "操作成功");
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "操作失败" + e);
            logger.error("financing->add()方法异常", e);
            e.printStackTrace();
            return jsonObject;
        }
        return jsonObject;
    }

    @RequestMapping(value = "/downloadFile", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void downloadFile(FinancingCostVo financingCostVo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        logger.info("rawtypes->downloadFile 被调用,入参" + financingCostVo);


        FinancingCost f = new FinancingCost();
        if (financingCostVo.getChannelClassified() != null)
            f.setChannelClassified(financingCostVo.getChannelClassified());

        if (financingCostVo.getChannelType() != null)
            f.setChannelType(financingCostVo.getChannelType());

        if (financingCostVo.getChannelName() != null)
            f.setChannelName(financingCostVo.getChannelName());

        if (financingCostVo.getChannelId() != null)
            f.setChannelId(financingCostVo.getChannelId());

        if (financingCostVo.getCreateTime() != null)
            f.setCreateTime(financingCostVo.getCreateTime());
        if (financingCostVo.getRepayMethod() != null) {
            f.setRepayMethod(financingCostVo.getRepayMethod());
        }

        if (financingCostVo.getChannelName()!=null){
            f.setChannelName(financingCostVo.getChannelName());
        } if (financingCostVo.getExt1()!=null){
            f.setExt1(financingCostVo.getExt1());
        }
        byte[] bytes = financingService.downloadFile(f);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(bytes,outputStream);


    }


    @RequestMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public  Object uploadFile( HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> objectObjectHashMap = Maps.newHashMap();
        objectObjectHashMap.put("外部", "0");
        objectObjectHashMap.put("自有", "1");
        objectObjectHashMap.put("混合", "2");
        //0:信托,1:p2p,2:银行
        HashMap<String, String> channelTypeMap = Maps.newHashMap();
        channelTypeMap.put("信托", "0");
        channelTypeMap.put("P2P", "1");
        channelTypeMap.put("银行", "2");
        channelTypeMap.put("自有资金", "3");
        channelTypeMap.put("股东资金", "4");
        channelTypeMap.put("金交所", "5");
        channelTypeMap.put("单笔项目", "6");
        channelTypeMap.put("其他", "7");
        channelTypeMap.put("信托&其他", "8");
        channelTypeMap.put("ABS", "9");


        //方式  计息类型 0:计头 1:计尾'
        HashMap<String, String> interestTypeMap = Maps.newHashMap();
        interestTypeMap.put("计头", "0");
        interestTypeMap.put("计尾", "1");
        //方式  0:等额本息，1:到期一次还本息，2:每期还息到期还本'
        HashMap<String, String> repayMethodMap = Maps.newHashMap();
        repayMethodMap.put("等额本息", "0");
        repayMethodMap.put("到期一次还本息", "1");
        repayMethodMap.put("每期还息到期还本", "2");
        ExcelDataFormatter excelDataFormatter = new ExcelDataFormatter();
        excelDataFormatter.set("channelClassified", objectObjectHashMap);
        excelDataFormatter.set("channelType",channelTypeMap);
        excelDataFormatter.set("repayMethod",repayMethodMap);
        excelDataFormatter.set("interestType",interestTypeMap);

        try {
            Map<String, Object> resultMap = ExcelUtil.readFromFile(excelDataFormatter, request.getInputStream(), FinancingCostVo.class);
            String operateUserName = request.getParameter("operateUserName");
            Object status = resultMap.get("status");
            if(!"success".equals(status)){
                jsonObject.put("code", "-1");
                jsonObject.put("msg", status.toString());
                return jsonObject;
            }
            List<FinancingCostVo> list = (List<FinancingCostVo>)resultMap.get("list");
            for (int i=0;i<list.size();i++){
                FinancingCostVo financingCostVo = list.get(i);
                FinancingCost financingCost = new FinancingCost();
                BeanUtils.copyProperties(financingCostVo,financingCost);
                financingCost.setOptUser(operateUserName);
                financingCost.setLoanDay(DateUtil.stringDateToDate2(financingCostVo.getLoanDayStr()));
                financingCost.setRepayDay(DateUtil.stringDateToDate2(financingCostVo.getRepayDayStr()));
                financingCost.setExt1("0");//待审核
                financingService.insert(financingCost);
            }
            jsonObject.put("code", "1");
            jsonObject.put("msg", "操作成功");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("批量录入异常",e);
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "操作失败");
        }
       return jsonObject;
    }


}
