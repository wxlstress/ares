package com.qudian.pay.ares.dao.mapper.local;

import com.qudian.pay.ares.dao.entity.local.SysParameter;
import com.qudian.pay.ares.dao.entity.local.SysParameterExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysParameterMapper {
    int countByExample(SysParameterExample example);

    int deleteByExample(SysParameterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysParameter record);

    int insertSelective(SysParameter record);

    List<SysParameter> selectByExample(SysParameterExample example);

    SysParameter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByExample(@Param("record") SysParameter record, @Param("example") SysParameterExample example);

    int updateByPrimaryKeySelective(SysParameter record);

    int updateByPrimaryKey(SysParameter record);
    String selectParamByParamType(String type);

   // Map<String,String> selectFtpInfo();
    List<Map<String,String>> selectFtpInfo();
}