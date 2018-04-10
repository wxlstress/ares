package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.local.PushPlatform;
import com.qudian.pay.ares.service.baseService.IBaseService;

/**
 * Created by youzhijie on 17/6/5.
 */
public interface PushPlatformService extends IBaseService<PushPlatform> {
    PushPlatform selectByPrimaryKey(Integer id);
}
