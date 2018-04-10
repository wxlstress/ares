package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.dao.entity.local.CostOriginExample;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.mapper.local.CostOriginMapper;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.CostOriginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by youzhijie on 17/6/5.
 */
@Service
public class CostOriginServiceImpl implements CostOriginService {
    @Resource
    private CostOriginMapper costOriginMapper;

    @Override
    public int count(CostOrigin record) {
        return 0;
    }

    @Override
    public int insert(CostOrigin record) {
        return costOriginMapper.insertSelective(record);
    }

    @Override
    public int delete(CostOrigin record) {
        return costOriginMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public CostOrigin selectByPrimaryKey(Integer id) {
        return costOriginMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CostOrigin> query(CostOrigin record) {
        return null;
    }

    @Override
    public int update(CostOrigin record) {
        return costOriginMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfoPO<CostOrigin> queryByPage(CostOrigin record, int startLimit, int endLimit) throws Exception {
        CostOriginExample costOriginExample=new CostOriginExample();
        CostOriginExample.Criteria cc=costOriginExample.createCriteria();

        if(ObjectUtil.isNotEmpty(record.getLoanCompany()))
            if(record.getLoanCompany()!=0)
                cc.andLoanCompanyEqualTo(record.getLoanCompany());

        if(ObjectUtil.isNotEmpty(record.getBusinessCompany()))
            if(record.getBusinessCompany()!=0)
                cc.andBusinessCompanyEqualTo(record.getBusinessCompany());

        if(ObjectUtil.isNotEmpty(record.getOrigin()))
            if(record.getOrigin()!=null)
                cc.andOriginEqualTo(record.getOrigin());

        if(ObjectUtil.isNotEmpty(record.getNatureOfFundsId()))
            if(record.getNatureOfFundsId()!=0)
                cc.andNatureOfFundsIdEqualTo(record.getNatureOfFundsId());

        if(ObjectUtil.isNotEmpty(record.getNatureOfFunds()))
            if(record.getNatureOfFunds()!=null)
                cc.andNatureOfFundsEqualTo(record.getNatureOfFunds());

        costOriginExample.setPageNum(startLimit, endLimit);
        costOriginExample.setOrderByClause("id desc");
        PageInfoPO<CostOrigin> res = new PageInfoPO<>();
        res.setResults(costOriginMapper.selectByExampleByPage(costOriginExample));
        res.setCount(costOriginMapper.countByExample(costOriginExample));
        res.setPageNum(startLimit);
        res.setPageSize(endLimit);
        //转换页面展示结果
        return res;
    }

}
