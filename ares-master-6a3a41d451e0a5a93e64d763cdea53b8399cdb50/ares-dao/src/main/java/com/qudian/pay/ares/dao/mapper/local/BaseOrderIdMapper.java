package com.qudian.pay.ares.dao.mapper.local;


import java.util.List;

import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.BaseOrderIdExample;
import org.apache.ibatis.annotations.Param;

public interface BaseOrderIdMapper {
    int countByExample(BaseOrderIdExample example);

    int deleteByExample(BaseOrderIdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseOrderId record);

    int insertSelective(BaseOrderId record);

    List<BaseOrderId> selectByExample(BaseOrderIdExample example);

    BaseOrderId selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseOrderId record, @Param("example") BaseOrderIdExample example);

    int updateByExample(@Param("record") BaseOrderId record, @Param("example") BaseOrderIdExample example);

    int updateByPrimaryKeySelective(BaseOrderId record);

    int updateByPrimaryKey(BaseOrderId record);

    List<BaseOrderId> selectByExampleByPage(BaseOrderIdExample example);
}