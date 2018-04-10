package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.dto.TaskInfoExt;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.service.baseService.IBaseService;
import com.qudian.pay.ares.dao.vo.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdelong on 17/1/13.
 */
public interface TaskService extends IBaseService<TaskInfo> {
    int insertReturnPK(TaskInfo record);

    int updateByExample(TaskInfo record);

    int updateAddById(Integer id, BigDecimal payLoanCapital, BigDecimal payLoanInterst, BigDecimal payBorrowInterst, int billItemsNum);

    public List<TaskInfo> queryByExt(TaskInfoExt record);

    int insertService(TaskInfo record) throws Exception;

    Map<String, Object> get() throws InterruptedException;
}

