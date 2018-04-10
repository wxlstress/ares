package com.qudian.pay.ares.service.baseService;

import com.qudian.pay.ares.dao.entity.local.PageInfoPO;

import java.util.List;

/**
 * Created by zhangdelong on 17/1/13.
 */
public interface IBaseService<T> {
    int count(T record) throws Exception;

    int insert(T record) throws Exception;

    int delete(T record) throws Exception;

    List<T> query(T record) throws Exception;

    int update(T record) throws Exception;

    /**
     * 分页查询
     *
     * @param record     条件
     * @param startLimit 页码
     * @param endLimit   每页记录数 默认30
     * @return
     */
    PageInfoPO<T> queryByPage(T record, int startLimit, int endLimit) throws Exception;
}
