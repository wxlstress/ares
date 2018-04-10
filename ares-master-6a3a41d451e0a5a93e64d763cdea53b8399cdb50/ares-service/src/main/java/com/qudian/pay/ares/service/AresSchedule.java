package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.laifenqi.Orders;
import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.service.common.Constant;
import com.qudian.pay.ares.service.impl.TransferServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangdelong on 17/1/14.
 */
@Service
public class AresSchedule {
    private static Logger logger = LoggerFactory.getLogger(AresSchedule.class);
    @Resource
    TransferService transferService;

    private int loanArea;

    public void setLoanArea(int loanArea) {
        this.loanArea = loanArea;
    }

    /*
     * 分润统一入口
     */
    public void currencyBondTransfer() {
        try {
            Date d = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            HttpServletRequest request1 = null;
            transferService.paramsAnalysis(request1, DateUtil.formatToDay2(cal.getTime()), DateUtil.formatToDay2(cal.getTime()), Constant.taskInfo.task_type_timer, this.loanArea);
        } catch (Exception e) {
            logger.error("网金社定时任务异常", e);
            e.printStackTrace();
        }

    }
}
