package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.laifenqi.Orders;
import com.qudian.pay.ares.service.baseService.IBaseService;

import java.util.List;

/**
 * Created by zhangdelong on 17/1/14.
 */
public interface OrderService extends IBaseService<Orders> {
    List<Orders> queryByOrderId(Integer orderId);
    Orders selectByPrimaryKey(Integer id);
}
