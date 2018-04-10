package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.laifenqi.Orders;
import com.qudian.pay.ares.dao.entity.laifenqi.OrdersExample;
import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.BaseOrderIdExample;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.mapper.laifenqi.OrdersMapper;
import com.qudian.pay.ares.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdelong on 17/1/14.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public int count(Orders record) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria cc = example.createCriteria();
        return ordersMapper.countByExample(example);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int delete(Orders record) {
        return 0;
    }

    @Override
    public List<Orders> query(Orders record) {
        OrdersExample example = null;
        return ordersMapper.selectByExample(example);
    }

    @Override
    public int update(Orders record) {
        return 0;
    }

    @Override
    public PageInfoPO<Orders> queryByPage(Orders record, int startLimit, int endLimit) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria cc = example.createCriteria();
        if (!StringUtils.isEmpty(record.getLoanArea())) {
            cc.andLoanAreaEqualTo(record.getLoanArea());
        }
        example.setPageNum(startLimit, endLimit);
        PageInfoPO<Orders> res = new PageInfoPO<Orders>();
        res.setResults(ordersMapper.selectByExampleByPage(example));
        return res;
    }

    @Override
    public List<Orders> queryByOrderId(Integer orderId) {
        OrdersExample example = new OrdersExample();
        OrdersExample.Criteria cc = example.createCriteria();
        cc.andIdEqualTo(orderId);
        return ordersMapper.selectByExample(example);
    }

    @Override
    public Orders selectByPrimaryKey(Integer id) {
        return ordersMapper.selectByPrimaryKey(id);
    }
}
