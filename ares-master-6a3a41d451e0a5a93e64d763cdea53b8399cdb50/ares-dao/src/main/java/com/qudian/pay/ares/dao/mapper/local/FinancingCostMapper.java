package com.qudian.pay.ares.dao.mapper.local;


import java.util.List;

import com.qudian.pay.ares.dao.entity.local.FinancingCost;
import com.qudian.pay.ares.dao.entity.local.FinancingCostExample;
import org.apache.ibatis.annotations.Param;

public interface FinancingCostMapper {
    int countByExample(FinancingCostExample example);

    int deleteByExample(FinancingCostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancingCost record);

    int insertSelective(FinancingCost record);

    List<FinancingCost> selectByExample(FinancingCostExample example);
    List<FinancingCost> selectByExampleByPage(FinancingCostExample example);

    FinancingCost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancingCost record, @Param("example") FinancingCostExample example);

    int updateByExample(@Param("record") FinancingCost record, @Param("example") FinancingCostExample example);

    int updateByPrimaryKeySelective(FinancingCost record);

    int updateByPrimaryKey(FinancingCost record);
}