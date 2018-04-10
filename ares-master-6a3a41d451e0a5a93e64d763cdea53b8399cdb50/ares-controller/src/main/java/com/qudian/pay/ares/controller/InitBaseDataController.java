package com.qudian.pay.ares.controller;

/**
 * Created by zhangdelong on 17/1/13.
 */

import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.mapper.local.TaskInfoMapper;
import com.qudian.pay.ares.service.InitBaseDataService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/init")
public class InitBaseDataController {
    private static Logger logger = LoggerFactory.getLogger(InitBaseDataController.class);
    @Resource
    InitBaseDataService initBaseDataService;
    @Resource
    TaskInfoMapper taskInfoMapper;

    JSONObject jsonObject = new JSONObject();

    @RequestMapping(value = "/initBaseData")
    @ResponseBody
    String init(String str) {
        String path = "/opt/data.txt";
        boolean flg = false;
        try {
            logger.info("调用->fileToDb()方法,入参{}", path);
            flg = initBaseDataService.fileToDb(path);
        } catch (Exception e) {
            logger.error("initBaseData()方法yichang");
            e.printStackTrace();

        }
        if (flg) {
            jsonObject.put("flg", flg);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    String test(String str) {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setCreateTime(new Date());
        taskInfo.setTaskType(0);
        taskInfo.setTaskStatus(1);
        taskInfoMapper.insert(taskInfo);
        return str;
    }
}
