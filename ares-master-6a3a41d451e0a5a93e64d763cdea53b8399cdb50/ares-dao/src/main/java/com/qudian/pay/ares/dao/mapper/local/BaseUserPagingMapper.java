package com.qudian.pay.ares.dao.mapper.local;

import com.qudian.pay.ares.dao.entity.local.BaseUserPaging;

public interface BaseUserPagingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserPaging record);

    int insertSelective(BaseUserPaging record);

    BaseUserPaging selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseUserPaging record);

    int updateByPrimaryKey(BaseUserPaging record);
}