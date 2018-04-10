package com.qudian.pay.ares.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qudian.pay.ares.dao.dto.CostOriginVo;
import com.qudian.pay.ares.dao.dto.PushPlatformVo;
import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.PushPlatform;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.CostOriginService;
import com.qudian.pay.ares.service.PushPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by youzhijie on 17/6/5.
 */
//资金性质参数配置
@Controller
@RequestMapping(value="costParameterSetting")
public class CostParameterSettingController {
    private static Logger logger = LoggerFactory.getLogger(FinancingController.class);

//    资金来源
    @Resource
    private CostOriginService costOriginService;
    @RequestMapping("/commit")
    @ResponseBody
    public JSONObject save(CostOriginVo costOriginVo){
        JSONObject jsonObject = new JSONObject();
        logger.info("costParameterSetting>commit#接收到参数"+costOriginVo.toString());
        try {
           CostOrigin costOrigin=toCostOrigin(costOriginVo);
            costOriginService.insert(costOrigin);
            jsonObject.put("code", "1");
            jsonObject.put("msg", "添加操作成功");
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "添加操作失败" + e);
            logger.error("costParameterSetting>commit#方法异常", e);
        }
        return jsonObject;
    }

    @RequestMapping("update")
    @ResponseBody
    public JSONObject update(CostOriginVo costOriginVo){
        JSONObject jsonObject = new JSONObject();
        logger.info("costParameterSetting>update#接收到参数"+costOriginVo.toString());
        try {
            CostOrigin costOrigin=toCostOrigin(costOriginVo);
            costOriginService.update(costOrigin);
            jsonObject.put("code", "1");
            String s=jsonObject.getString("loanCompany");
            System.out.print(s);
            jsonObject.put("msg", "更新操作成功");
            System.out.print(costOrigin.getLoanCompany());
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "更新操作失败" + e);
            logger.error("资金性质参数配置->add()方法异常", e);
        }
        return jsonObject;
    }

    @RequestMapping("queryById")
    @ResponseBody
    public JSONObject queryById(CostOriginVo costOriginVo){
        logger.info("costParameterSetting>queryById#接收到参数"+costOriginVo.toString());

        CostOrigin costOrigin= costOriginService.selectByPrimaryKey(costOriginVo.getId());
        return (JSONObject) JSON.toJSON(costOrigin);
    }

    @RequestMapping("queryList")
    @ResponseBody
    public JSONObject queryList(CostOriginVo costOriginVo,HttpServletRequest request){
        logger.info("costParameterSetting>queryList#接收到参数"+costOriginVo.toString());

        JSONObject jsonObject = new JSONObject();

        CostOrigin costOrigin=toCostOrigin(costOriginVo);

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
        PageInfoPO<CostOrigin> taskInfoPageInfoPO = null;
        try {
            taskInfoPageInfoPO = costOriginService.queryByPage(costOrigin, startLimit, endLimit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int totalPage = (taskInfoPageInfoPO.getCount() + Integer.valueOf(pageSize) - 1) / Integer.valueOf(pageSize);
        jsonObject.put("rows", taskInfoPageInfoPO.getResults());
        jsonObject.put("page", page);
        jsonObject.put("total", totalPage);
        jsonObject.put("records", taskInfoPageInfoPO.getCount());
        return jsonObject;
    }

    private CostOrigin toCostOrigin(CostOriginVo costOriginVo){

        CostOrigin costOrigin= new  CostOrigin();
        if(ObjectUtil.isNotEmpty(costOriginVo.getLoanCompany()))
            costOrigin.setLoanCompany(costOriginVo.getLoanCompany());

        if(ObjectUtil.isNotEmpty(costOriginVo.getBusinessCompany()))
            costOrigin.setBusinessCompany(costOriginVo.getBusinessCompany());

        if(ObjectUtil.isNotEmpty(costOriginVo.getOrigin()))
            costOrigin.setOrigin(costOriginVo.getOrigin());

        if(ObjectUtil.isNotEmpty(costOriginVo.getNatureOfFundsId()))
            costOrigin.setNatureOfFundsId(costOriginVo.getNatureOfFundsId());

        if(ObjectUtil.isNotEmpty(costOriginVo.getNatureOfFunds()))
            costOrigin.setNatureOfFunds(costOriginVo.getNatureOfFunds());

        costOrigin.setId(costOriginVo.getId());
        costOrigin.setCreateTime(new Date());
        costOrigin.setUpdateTime(new Date());
        costOrigin.setOptUser(costOriginVo.getOptUser());
        return costOrigin;
    }
//    推标平台
    @Resource
    private PushPlatformService pushPlatformService;

    @RequestMapping("pushPlatformCommit")
    @ResponseBody
    public JSONObject pushFlagCommit(PushPlatformVo pushPlatformVo){
        logger.info("costParameterSetting>pushPlatformCommit#接收到参数"+pushPlatformVo.toString());

        JSONObject jsonObject = new JSONObject();
        try {
            PushPlatform pushPlatform=toPushPlatform(pushPlatformVo);
            pushPlatformService.insert(pushPlatform);
            jsonObject.put("code", "1");
            jsonObject.put("msg", "添加操作成功");
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "添加操作失败" + e);
            logger.error("资金性质参数配置->add()方法异常", e);
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping("pushPlatformUpdate")
    @ResponseBody
    public JSONObject updateByAjaxPushFlag(PushPlatformVo pushPlatformVo){
        logger.info("costParameterSetting>pushPlatformUpdate#接收到参数"+pushPlatformVo.toString());
        JSONObject jsonObject = new JSONObject();
        try {
            PushPlatform pushPlatform=toPushPlatform(pushPlatformVo);
            pushPlatformService.update(pushPlatform);
            jsonObject.put("code", "1");
            jsonObject.put("msg", "更新操作成功");
        } catch (Exception e) {
            jsonObject.put("code", "-1");
            jsonObject.put("msg", "更新操作失败" + e);
            logger.error("资金性质参数配置->update()方法异常", e);
            e.printStackTrace();
        }
        return jsonObject;
    }

    @RequestMapping("queryPushPlatformById")
    @ResponseBody
    public JSONObject pushFlagQueryById(PushPlatformVo pushPlatformVo){
        PushPlatform pushPlatform= pushPlatformService.selectByPrimaryKey(pushPlatformVo.getId());
        return (JSONObject) JSON.toJSON(pushPlatform);
    }

    @RequestMapping("queryPushPlatformList")
    @ResponseBody
    public JSONObject queryFlagUpdatePlatformList(PushPlatformVo pushPlatformVo,HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        PushPlatform pushPlatform=toPushPlatform(pushPlatformVo);
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
        PageInfoPO<PushPlatform> taskInfoPageInfoPO = null;
        try {
            taskInfoPageInfoPO = pushPlatformService.queryByPage(pushPlatform, startLimit, endLimit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int totalPage = (taskInfoPageInfoPO.getCount() + Integer.valueOf(pageSize) - 1) / Integer.valueOf(pageSize);
        jsonObject.put("rows", taskInfoPageInfoPO.getResults());
        jsonObject.put("page", page);
        jsonObject.put("total", totalPage);
        jsonObject.put("records", taskInfoPageInfoPO.getCount());
        return jsonObject;
    }

    private PushPlatform toPushPlatform(PushPlatformVo pushPlatformVo){
        PushPlatform pushPlatform=new PushPlatform();
        if(ObjectUtil.isNotEmpty(pushPlatformVo.getPushMethod()))
            pushPlatform.setPushMethod(pushPlatformVo.getPushMethod());

        if(ObjectUtil.isNotEmpty(pushPlatformVo.getPlatformId()))
            pushPlatform.setPlatformId(pushPlatformVo.getPlatformId());

        if(ObjectUtil.isNotEmpty(pushPlatformVo.getCollaborationPlatform()))
            pushPlatform.setCollaborationPlatform(pushPlatformVo.getCollaborationPlatform());

        if(ObjectUtil.isNotEmpty(pushPlatformVo.getPlatformClassification()))
            pushPlatform.setPlatformClassification(pushPlatformVo.getPlatformClassification());

        if(ObjectUtil.isNotEmpty(pushPlatformVo.getPushState()))
            pushPlatform.setPushState(pushPlatformVo.getPushState());

        pushPlatform.setId(pushPlatformVo.getId());
        pushPlatform.setCreateTime(new Date());
        pushPlatform.setUpdateTime(new Date());
        return pushPlatform;
    }
}
