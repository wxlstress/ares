package com.qudian.pay.ares.controller;

import com.qudian.pay.ares.service.AresSchedule;
import com.qudian.pay.ares.service.BilltemService;
import com.qudian.pay.ares.service.TaskService;
import com.qudian.pay.ares.service.UtilService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qudian.pay.ares.dao.vo.CsvVO;
import com.qudian.pay.ares.dao.vo.FileVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by zhangdelong on 17/1/18.
 */
@Controller
@RequestMapping("/t")
@Scope("prototype")
public class TestController {
    Logger logger = Logger.getLogger(TestController.class.getName());
    private int index = 0;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() throws Exception {
        logger.info("spring mvc hello world!" + index++);
        return null;
    }
}
