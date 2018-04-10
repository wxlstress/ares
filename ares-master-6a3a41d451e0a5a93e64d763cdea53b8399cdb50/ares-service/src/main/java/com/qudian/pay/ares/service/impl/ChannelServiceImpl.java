package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.local.Channel;
import com.qudian.pay.ares.dao.entity.local.ChannelExample;
import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.mapper.local.ChannelMapper;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.ChannelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdelong on 17/10/20.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Resource
    private ChannelMapper channelMapper;

    @Override
    public int count(Channel record) throws Exception {
        return 0;
    }

    @Override
    public int insert(Channel record) throws Exception {

        return channelMapper.insertSelective(record);
    }

    @Override
    public int delete(Channel record) throws Exception {
        return 0;
    }

    @Override
    public List<Channel> query(Channel record) throws Exception {
        ChannelExample channelExample = new ChannelExample();
        if (ObjectUtil.isNotEmpty(record.getChannelStatus())){
            channelExample.createCriteria().andChannelStatusEqualTo(record.getChannelStatus());
        }

        return channelMapper.selectByExample(channelExample);
    }

    @Override
    public int update(Channel record) throws Exception {

        return channelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfoPO<Channel> queryByPage(Channel record, int startLimit, int endLimit) throws Exception {
        ChannelExample channelExample = new ChannelExample();
        if (ObjectUtil.isNotEmpty(record.getChannelStatus())){
            channelExample.createCriteria().andChannelStatusEqualTo(record.getChannelStatus());
        }

        if (ObjectUtil.isNotEmpty(record.getChannelName())){
            channelExample.createCriteria().andChannelNameEqualTo(record.getChannelName());
        }
        channelExample.setPageNum(startLimit, endLimit);
        channelExample.setOrderByClause("id desc");
        PageInfoPO<Channel> res = new PageInfoPO<Channel>();
        res.setResults(channelMapper.selectByExampleByPage(channelExample));
        res.setCount(channelMapper.countByExample(channelExample));
        res.setPageNum(startLimit);
        res.setPageSize(endLimit);
        return res;
    }

    @Override
    public Channel selectByPrimaryKey(Integer id) {
        return null;
    }
}
