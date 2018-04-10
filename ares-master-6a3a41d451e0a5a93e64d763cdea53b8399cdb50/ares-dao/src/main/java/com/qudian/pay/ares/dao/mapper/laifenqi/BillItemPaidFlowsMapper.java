package com.qudian.pay.ares.dao.mapper.laifenqi;

import com.qudian.pay.ares.dao.entity.laifenqi.BillItemPaidFlows;
import com.qudian.pay.ares.dao.entity.laifenqi.BillItemPaidFlowsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillItemPaidFlowsMapper {
    int countByExample(BillItemPaidFlowsExample example);

    int deleteByExample(BillItemPaidFlowsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillItemPaidFlows record);

    int insertSelective(BillItemPaidFlows record);

    List<BillItemPaidFlows> selectByExample(BillItemPaidFlowsExample example);

    BillItemPaidFlows selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillItemPaidFlows record, @Param("example") BillItemPaidFlowsExample example);

    int updateByExample(@Param("record") BillItemPaidFlows record, @Param("example") BillItemPaidFlowsExample example);

    int updateByPrimaryKeySelective(BillItemPaidFlows record);

    int updateByPrimaryKey(BillItemPaidFlows record);
}