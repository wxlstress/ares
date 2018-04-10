package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.local.FinancingCost;
import com.qudian.pay.ares.service.baseService.IBaseService;

public interface FinancingService extends IBaseService<FinancingCost> {
    FinancingCost selectByPrimaryKey(Integer id);
    public byte[] downloadFile(FinancingCost record);
}
