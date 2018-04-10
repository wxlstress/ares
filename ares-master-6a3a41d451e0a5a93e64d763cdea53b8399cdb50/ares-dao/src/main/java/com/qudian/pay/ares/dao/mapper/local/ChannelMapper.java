package com.qudian.pay.ares.dao.mapper.local;

import com.qudian.pay.ares.dao.entity.local.Channel;
import com.qudian.pay.ares.dao.entity.local.ChannelExample;
import java.util.List;

import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.dao.entity.local.CostOriginExample;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {
    int countByExample(ChannelExample example);

    int deleteByExample(ChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    List<Channel> selectByExample(ChannelExample example);

    List<Channel> selectByExampleByPage(ChannelExample example);

    Channel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByExample(@Param("record") Channel record, @Param("example") ChannelExample example);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}