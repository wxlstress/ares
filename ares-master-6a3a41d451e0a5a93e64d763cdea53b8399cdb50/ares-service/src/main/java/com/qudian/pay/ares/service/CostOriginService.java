package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.service.baseService.IBaseService;

/**
 * Created by youzhijie on 17/6/5.
 */
public interface CostOriginService extends IBaseService<CostOrigin> {
    CostOrigin selectByPrimaryKey(Integer id);
}
