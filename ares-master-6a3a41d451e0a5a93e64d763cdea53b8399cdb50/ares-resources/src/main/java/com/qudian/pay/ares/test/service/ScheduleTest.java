package com.qudian.pay.ares.test.service;

import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.service.AresSchedule;
import com.qudian.pay.ares.service.TransferService;
import com.qudian.pay.ares.service.common.Constant;
import org.junit.Test;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ziyu on 2017/5/21.
 */
public class ScheduleTest  extends BaseTest
{
    @Resource
    TransferService transferService;

@Test
 public void test() throws Exception {
    Date d = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    cal.add(Calendar.DAY_OF_MONTH, -1);
    HttpServletRequest request1 = null;
    Date sd = DateUtil.getCurrentDayStartTime(cal.getTime());
    Date ed = DateUtil.getCurrentDayEndTime(cal.getTime());
    transferService.wjsBondTransfer(sd,ed,1,49);
  //  transferService.paramsAnalysis(request1, DateUtil.formatToDay2(cal.getTime()), DateUtil.formatToDay2(cal.getTime()), Constant.taskInfo.task_type_timer, 49);

}

}
