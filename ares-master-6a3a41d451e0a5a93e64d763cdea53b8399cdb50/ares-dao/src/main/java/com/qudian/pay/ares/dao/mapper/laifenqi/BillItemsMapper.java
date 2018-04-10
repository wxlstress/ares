package com.qudian.pay.ares.dao.mapper.laifenqi;

import com.qudian.pay.ares.dao.entity.laifenqi.BillItems;
import com.qudian.pay.ares.dao.entity.laifenqi.BillItemsExample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BillItemsMapper {
    int countByExample(BillItemsExample example);


    int deleteByExample(BillItemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillItems record);

    int insertSelective(BillItems record);

    List<BillItems> selectByExample(BillItemsExample example);

    BillItems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BillItems record, @Param("example") BillItemsExample example);

    int updateByExample(@Param("record") BillItems record, @Param("example") BillItemsExample example);

    int updateByPrimaryKeySelective(BillItems record);

    int updateByPrimaryKey(BillItems record);

    int countByOrdersAndbill_items(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate, @Param("payStatus") int payStatus, @Param("status") int status, @Param("loanArea") int loanArea);


    List<BillItems> queryOrdersAndbill_items(@Param("beginDate") Date bebeginDate, @Param("endDate") Date endDate, @Param("payStatus") int payStatus, @Param("status") int status, @Param("startLimit") int startLimit, @Param("pageSize") int pageSize, @Param("loanArea") int loanArea);

    List<BillItems> selectByBillidList(@Param("beginDate") Date bebeginDate, @Param("endDate") Date endDate, @Param("items") List<Integer> items);

}