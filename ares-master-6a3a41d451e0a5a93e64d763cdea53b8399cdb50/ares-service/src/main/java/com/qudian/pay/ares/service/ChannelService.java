package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.local.Channel;
import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.service.baseService.IBaseService;

/**
 * Created by youzhijie on 17/6/5.
 */
public interface ChannelService extends IBaseService<Channel> {
    Channel selectByPrimaryKey(Integer id);
}
