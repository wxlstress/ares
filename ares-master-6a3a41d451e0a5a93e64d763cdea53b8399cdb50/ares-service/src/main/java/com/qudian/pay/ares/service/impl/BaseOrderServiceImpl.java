package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.BaseOrderIdExample;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.mapper.local.BaseOrderIdMapper;
import com.qudian.pay.ares.service.BaseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdelong on 17/1/14.
 */
@Service
public class BaseOrderServiceImpl implements BaseOrderService {
    private static Logger logger = LoggerFactory.getLogger(BaseOrderServiceImpl.class);

    @Resource
    private BaseOrderIdMapper baseOrderIdMapper;

    @Override
    public int count(BaseOrderId record) {
        BaseOrderIdExample example = new BaseOrderIdExample();
        BaseOrderIdExample.Criteria cc = example.createCriteria();
        return baseOrderIdMapper.countByExample(example);
    }

    @Override
    public int insert(BaseOrderId record) {
        logger.info("insert,{}",record.getOrderId());
        return baseOrderIdMapper.insert(record);
    }

    @Override
    public int delete(BaseOrderId record) {
        return 0;
    }

    @Override
    public List<BaseOrderId> query(BaseOrderId record) {
        return null;
    }

    @Override
    public int update(BaseOrderId record) {
        return 0;
    }

    @Override
    public PageInfoPO<BaseOrderId> queryByPage(BaseOrderId record, int startLimit, int endLimit) throws Exception {
        BaseOrderIdExample example = new BaseOrderIdExample();
        example.setPageNum(startLimit, endLimit);
        PageInfoPO<BaseOrderId> res = new PageInfoPO<BaseOrderId>();
        res.setResults(baseOrderIdMapper.selectByExampleByPage(example));
        return res;
    }
}
