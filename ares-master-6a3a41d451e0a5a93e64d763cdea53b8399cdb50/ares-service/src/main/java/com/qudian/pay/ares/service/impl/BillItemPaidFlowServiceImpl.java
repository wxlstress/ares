package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.laifenqi.BillItemPaidFlows;
import com.qudian.pay.ares.dao.entity.laifenqi.BillItemPaidFlowsExample;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.mapper.laifenqi.BillItemPaidFlowsMapper;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.BillItemPaidFlowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangdelong on 17/1/14.
 */
@Service
public class BillItemPaidFlowServiceImpl implements BillItemPaidFlowService {
    @Resource
    BillItemPaidFlowsMapper billItemPaidFlowsMapper;

    @Override
    public int count(BillItemPaidFlows record) {
        BillItemPaidFlowsExample example = new BillItemPaidFlowsExample();
        BillItemPaidFlowsExample.Criteria cc = example.createCriteria();
        return billItemPaidFlowsMapper.countByExample(example);
    }

    @Override
    public int insert(BillItemPaidFlows record) {
        return billItemPaidFlowsMapper.insert(record);
    }

    @Override
    public int delete(BillItemPaidFlows record) {
        return 0;
    }

    @Override
    public List<BillItemPaidFlows> query(BillItemPaidFlows record) {
        BillItemPaidFlowsExample example = new BillItemPaidFlowsExample();
        BillItemPaidFlowsExample.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(record.getBillItemId())) {
            criteria.andBillItemIdEqualTo(record.getBillItemId());
            criteria.andPayWayNotEqualTo("discount");
        }
        if (ObjectUtil.isNotEmpty(record.getPayType())) {

            List<Byte> values = new ArrayList<>();
            //1正常还款  9 退款
            values.add((byte) 1);
            values.add((byte) 9);
            //
            if (record.getPayType()== 6){
                criteria.andPayTypeIn(values);
            }
        }

        return billItemPaidFlowsMapper.selectByExample(example);
    }

    @Override
    public int update(BillItemPaidFlows record) {
        return 0;
    }

    @Override
    public PageInfoPO<BillItemPaidFlows> queryByPage(BillItemPaidFlows record, int startLimit, int endLimit) {
        return null;
    }


}
