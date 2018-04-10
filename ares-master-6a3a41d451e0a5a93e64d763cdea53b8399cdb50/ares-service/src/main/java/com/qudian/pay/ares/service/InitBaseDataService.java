package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.service.baseService.IBaseService;

/**
 * Created by zhangdelong on 17/1/13.
 */
public interface InitBaseDataService extends IBaseService<BaseOrderId> {
    boolean fileToDb(String path) throws Exception;
}
