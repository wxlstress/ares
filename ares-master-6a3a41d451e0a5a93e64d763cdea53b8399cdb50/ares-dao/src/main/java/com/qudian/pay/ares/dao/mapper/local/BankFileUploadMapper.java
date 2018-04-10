package com.qudian.pay.ares.dao.mapper.local;

import com.qudian.pay.ares.dao.entity.local.BankFileUpload;
import com.qudian.pay.ares.dao.entity.local.BankFileUploadExample;
import java.util.List;

import com.qudian.pay.ares.dao.entity.local.Channel;
import org.apache.ibatis.annotations.Param;

public interface BankFileUploadMapper {
    int countByExample(BankFileUploadExample example);

    int deleteByExample(BankFileUploadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BankFileUpload record);

    int insertSelective(BankFileUpload record);

    List<BankFileUpload> selectByExample(BankFileUploadExample example);

    List<BankFileUpload> selectByExampleByPage(BankFileUploadExample example);

    BankFileUpload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BankFileUpload record, @Param("example") BankFileUploadExample example);

    int updateByExample(@Param("record") BankFileUpload record, @Param("example") BankFileUploadExample example);

    int updateByPrimaryKeySelective(BankFileUpload record);

    int updateByPrimaryKey(BankFileUpload record);
}