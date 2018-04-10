package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.laifenqi.BillItems;
import com.qudian.pay.ares.dao.entity.laifenqi.Orders;
import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.service.baseService.IBaseService;
import com.qudian.pay.ares.dao.vo.CsvVO;

import java.util.Date;
import java.util.List;

/**
 * Created by zhangdelong on 17/1/14.
 */
public interface BilltemService extends IBaseService<BillItems> {

    List<BillItems> queryByList(List<BaseOrderId> orderIds, Date beginDate, Date endDate) throws Exception;

    List<CsvVO> bondTransfer(List<BillItems> billItemsList, Integer taskId, int loanArea) throws Exception;

    void toFtp(int taskId, List<CsvVO> res,  int loanArea, Date date) throws Exception;

    public List<BillItems> queryByOrders(List<Orders> orderIds, Date beginDate, Date endDate) throws Exception;

    PageInfoPO<BillItems> queryOrdersAndbillItems(Date beginDate, Date endDate, int startLimit, int endLimit, int loanArea) throws Exception;

    int countByOrdersAndbillItems(Date beginDate, Date endDate, int loanArea);

}
