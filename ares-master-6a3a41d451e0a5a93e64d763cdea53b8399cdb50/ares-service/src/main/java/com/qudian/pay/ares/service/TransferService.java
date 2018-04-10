package com.qudian.pay.ares.service;


import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by zhangdelong on 17/1/15.
 */
public interface TransferService {
    void bondTransfer(Date beginDate, Date endDate, int taskId,  int loanArea) throws Exception;

    void wjsBondTransfer(Date beginDate, Date endDate, int taskId, int loanArea);

    JSONObject paramsAnalysis(HttpServletRequest request, String beginDate, String endDate, Integer taskType, int loanArea) throws Exception;


}
