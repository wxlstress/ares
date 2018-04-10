package com.qudian.pay.ares.dao.mapper.local;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.entity.local.TaskInfoExample;
import org.apache.ibatis.annotations.Param;

public interface TaskInfoMapper {
    int countByExample(TaskInfoExample example);

    int deleteByExample(TaskInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskInfo record);

    int insertSelective(TaskInfo record);

    int insertReturnPK(TaskInfo record);

    List<TaskInfo> selectByExample(TaskInfoExample example);

    List<TaskInfo> selectByExampleByPage(TaskInfoExample example);

    TaskInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskInfo record, @Param("example") TaskInfoExample example);

    int updateByExample(@Param("record") TaskInfo record, @Param("example") TaskInfoExample example);

    int updateByPrimaryKeySelective(TaskInfo record);

    int updateByPrimaryKey(TaskInfo record);

    int updateAddById(@Param("id") Integer id, @Param("payLoanCapital") BigDecimal payLoanCapital, @Param("payLoanInterst") BigDecimal payLoanInterst, @Param("payBorrowInterst") BigDecimal payBorrowInterst, @Param("billItemsNum") Integer billItemsNum);

    Map<String, Object> get();
}