package com.qudian.pay.ares.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qudian.pay.ares.dao.dto.CostOriginVo;
import com.qudian.pay.ares.dao.dto.FinancingCostVo;
import com.qudian.pay.ares.dao.entity.local.Channel;
import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.dao.entity.local.FinancingCost;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.service.ChannelService;
import com.qudian.pay.ares.service.CostOriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangdelong on 17/10/20.
 */

@Controller
@RequestMapping(value = "channel")
public class ChannelController {
    private static Logger logger = LoggerFactory.getLogger(ChannelController.class);

    @Resource
    private ChannelService channelService;

    @RequestMapping("/getAllChannel")
    @ResponseBody
    public JSONObject getAllChannel(Channel channel) {
        JSONObject jsonObject = new JSONObject();
        logger.info("channel>getAllChannel#接收到参数" + channel.toString());
        try {
            jsonObject.put("result", channelService.query(channel));
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return (JSONObject) jsonObject.put("result", null);
        }
    }

    @RequestMapping(value = "/queryListByjax", produces = "application/json;charset=UTF-8")
    @ResponseBody

    public JSONObject getList(Channel channel, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObject = new JSONObject();
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
        PageInfoPO<Channel> taskInfoPageInfoPO = channelService.queryByPage(channel, startLimit, endLimit);

        int totalPage = (taskInfoPageInfoPO.getCount() + Integer.valueOf(pageSize) - 1) / Integer.valueOf(pageSize);
        jsonObject.put("rows", taskInfoPageInfoPO.getResults());
        jsonObject.put("page", page);
        jsonObject.put("total", totalPage);
        jsonObject.put("records", taskInfoPageInfoPO.getCount());
        return jsonObject;
    }

    @RequestMapping(value = "/addChannel", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject addChannel(Channel channel) {
        JSONObject jsonObject = new JSONObject();
        logger.info("channel>getAllChannel#接收到参数" + channel.toString());
        try {
            channelService.insert(channel);
            jsonObject.put("result", "添加成功");
            return jsonObject ;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", "添加失败" + e);
            return jsonObject ;
        }
    }

    @RequestMapping(value = "/updateChannel", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JSONObject update(Channel channel) {
        JSONObject jsonObject = new JSONObject();
        logger.info("channel>getAllChannel#接收到参数" + channel.toString());
        try {
            channelService.update(channel);
            jsonObject.put("result", "更新成功");
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("result", "更新失败" + e);
            return jsonObject ;
        }
    }

}
