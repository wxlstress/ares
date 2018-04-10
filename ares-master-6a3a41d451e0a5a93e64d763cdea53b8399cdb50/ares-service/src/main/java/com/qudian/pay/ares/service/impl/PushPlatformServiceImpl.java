package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.PushPlatform;
import com.qudian.pay.ares.dao.entity.local.PushPlatformExample;
import com.qudian.pay.ares.dao.mapper.local.PushPlatformMapper;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.PushPlatformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by youzhijie on 17/6/5.
 */
@Service
public class PushPlatformServiceImpl implements PushPlatformService {
    @Resource
    private PushPlatformMapper pushPlatformMapper;

    @Override
    public int count(PushPlatform record) {
        return 0;
    }

    @Override
    public int insert(PushPlatform record) {
        return pushPlatformMapper.insertSelective(record);
    }

    @Override
    public int delete(PushPlatform record) {
        return pushPlatformMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public PushPlatform selectByPrimaryKey(Integer id) {
        return pushPlatformMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PushPlatform> query(PushPlatform record) {
        return null;
    }

    @Override
    public int update(PushPlatform record) {
        return pushPlatformMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfoPO<PushPlatform> queryByPage(PushPlatform record, int startLimit, int endLimit) throws Exception {
        PushPlatformExample pushPlatformExample=new PushPlatformExample();
        PushPlatformExample.Criteria pc=pushPlatformExample.createCriteria();
        if(ObjectUtil.isNotEmpty(record.getPushMethod()))
            if(record.getPushMethod()!=null)
                pc.andPushMethodEqualTo(record.getPushMethod());

        if(ObjectUtil.isNotEmpty(record.getPlatformId()))
            if(record.getPlatformId()!=0)
                pc.andPlatformIdEqualTo(record.getPlatformId());

        if(ObjectUtil.isNotEmpty(record.getCollaborationPlatform()))
            if(record.getCollaborationPlatform()!=null)
                pc.andCollaborationPlatformEqualTo(record.getCollaborationPlatform());

        if(ObjectUtil.isNotEmpty(record.getPushState()))
            if(record.getPushState()!=null)
                pc.andPushStateEqualTo(record.getPushState());

        if(ObjectUtil.isNotEmpty(record.getPlatformClassification()))
            if(record.getPlatformClassification()!=null)
                pc.andPlatformClassificationEqualTo(record.getPlatformClassification());

        pushPlatformExample.setPageNum(startLimit, endLimit);
        pushPlatformExample.setOrderByClause("id desc");
        PageInfoPO<PushPlatform> res = new PageInfoPO<PushPlatform>();
        res.setResults(pushPlatformMapper.selectByExampleByPage(pushPlatformExample));
        res.setCount(pushPlatformMapper.countByExample(pushPlatformExample));
        res.setPageNum(startLimit);
        res.setPageSize(endLimit);
        //转换页面展示结果
        return res;
    }
}
