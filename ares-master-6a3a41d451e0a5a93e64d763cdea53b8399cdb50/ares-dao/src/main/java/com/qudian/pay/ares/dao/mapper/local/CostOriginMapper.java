package com.qudian.pay.ares.dao.mapper.local;

import com.qudian.pay.ares.dao.entity.local.CostOrigin;
import com.qudian.pay.ares.dao.entity.local.CostOriginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostOriginMapper {
    int countByExample(CostOriginExample example);

    int deleteByExample(CostOriginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CostOrigin record);

    int insertSelective(CostOrigin record);

    List<CostOrigin> selectByExample(CostOriginExample example);
    List<CostOrigin> selectByExampleByPage(CostOriginExample example);

    CostOrigin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CostOrigin record, @Param("example") CostOriginExample example);

    int updateByExample(@Param("record") CostOrigin record, @Param("example") CostOriginExample example);

    int updateByPrimaryKeySelective(CostOrigin record);

    int updateByPrimaryKey(CostOrigin record);
}