package com.qudian.pay.ares.dao.mapper.local;

import com.qudian.pay.ares.dao.entity.local.PushPlatform;
import com.qudian.pay.ares.dao.entity.local.PushPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PushPlatformMapper {
    int countByExample(PushPlatformExample example);

    int deleteByExample(PushPlatformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PushPlatform record);

    int insertSelective(PushPlatform record);

    List<PushPlatform> selectByExample(PushPlatformExample example);
    List<PushPlatform> selectByExampleByPage(PushPlatformExample example);

    PushPlatform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PushPlatform record, @Param("example") PushPlatformExample example);

    int updateByExample(@Param("record") PushPlatform record, @Param("example") PushPlatformExample example);

    int updateByPrimaryKeySelective(PushPlatform record);

    int updateByPrimaryKey(PushPlatform record);
}