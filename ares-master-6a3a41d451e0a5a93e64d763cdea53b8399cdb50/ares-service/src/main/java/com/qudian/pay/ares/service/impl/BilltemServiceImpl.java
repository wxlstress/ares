package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.entity.laifenqi.BillItemPaidFlows;
import com.qudian.pay.ares.dao.entity.laifenqi.BillItems;
import com.qudian.pay.ares.dao.entity.laifenqi.BillItemsExample;
import com.qudian.pay.ares.dao.entity.laifenqi.Orders;
import com.qudian.pay.ares.dao.entity.local.BaseOrderId;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.mapper.laifenqi.BillItemsMapper;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.service.*;
import com.qudian.pay.ares.service.common.Constant;
import com.qudian.pay.ares.service.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.qudian.pay.ares.dao.vo.CsvVO;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zhangdelong on 17/1/14.
 */
@Service
public class BilltemServiceImpl implements BilltemService {
    private static Logger logger = LoggerFactory.getLogger(BilltemServiceImpl.class);
    @Resource
    private TaskService taskService;

    @Resource
    private BillItemsMapper billItemsMapper;
    @Resource
    private OrderService orderService;
    @Resource
    private BillItemPaidFlowService billItemPaidFlowService;

    @Resource
    private ICSVSftpService csvSftpService;


    @Override
    public int count(BillItems record) {
        return 0;
    }

    @Override
    public int insert(BillItems record) {
        return billItemsMapper.insert(record);
    }

    @Override
    public int delete(BillItems record) {
        return 0;
    }

    @Override
    public List<BillItems> query(BillItems record) {
        BillItemsExample example = new BillItemsExample();
        BillItemsExample.Criteria cc = example.createCriteria();
//        cc.andIdIn()
        return billItemsMapper.selectByExample(example);
    }

    @Override
    public int update(BillItems record) {
        return 0;
    }

    @Override
    public PageInfoPO<BillItems> queryByPage(BillItems record, int startLimit, int endLimit) {
        return null;
    }


    @Override
    public List<BillItems> queryByList(List<BaseOrderId> orderIds, Date beginDate, Date endDate) throws Exception {
        BillItemsExample example = new BillItemsExample();
        BillItemsExample.Criteria cc = example.createCriteria();
        List<Integer> billId = new ArrayList<Integer>();
        if (!ObjectUtil.isEmpty(orderIds)) {
            for (int i = 0; i < orderIds.size(); i++) {
                billId.add(orderIds.get(i).getBillId());
            }
            cc.andIdIn(billId);
        }
        return billItemsMapper.selectByBillidList(beginDate, endDate, billId);
    }


    @Override
    public List<BillItems> queryByOrders(List<Orders> orderIds, Date beginDate, Date endDate) throws Exception {
        BillItemsExample example = new BillItemsExample();
        BillItemsExample.Criteria cc = example.createCriteria();
        List<Integer> oid = new ArrayList<Integer>();
        if (!ObjectUtil.isEmpty(orderIds)) {
            for (int i = 0; i < orderIds.size(); i++) {
                oid.add(orderIds.get(i).getId());
            }
            cc.andOrderIdIn(oid);
        } else {
            return null;
        }
        cc.andNotifyTimeGreaterThanOrEqualTo(beginDate);
        cc.andNotifyTimeLessThanOrEqualTo(endDate);
        //支付状态 已支付
        cc.andPayStatusEqualTo((byte) 2);
        //订单状态,有效
        cc.andStatusEqualTo((byte) 1);

        return billItemsMapper.selectByExample(example);
    }

    @Override
    public PageInfoPO<BillItems> queryOrdersAndbillItems(Date beginDate, Date endDate, int startLimit, int endLimit, int loanArea) throws Exception {
//        BillItemsExample example = new BillItemsExample();
//        BillItemsExample.Criteria cc = example.createCriteria();
//        cc.andNotifyTimeGreaterThanOrEqualTo(beginDate);
//        cc.andNotifyTimeLessThanOrEqualTo(endDate);
//        //支付状态 已支付
//        cc.andPayStatusEqualTo((byte) 2);
//        //订单状态,有效
//        cc.andStatusEqualTo((byte) 1);
//        example.setPageNum(startLimit, endLimit);
        PageInfoPO<BillItems> res = new PageInfoPO<BillItems>();

        res.setResults(billItemsMapper.queryOrdersAndbill_items(beginDate, endDate, 2, 1, startLimit, endLimit, loanArea));
        return res;
    }

    @Override
    public int countByOrdersAndbillItems(Date beginDate, Date endDate, int loanArea) {
        return billItemsMapper.countByOrdersAndbill_items(beginDate, endDate, 2, 1, loanArea);
    }


    @Override
    public List<CsvVO> bondTransfer(List<BillItems> billItemsList, Integer taskId, int loanArea) throws Exception {
        List<CsvVO> res = new ArrayList<CsvVO>();

        logger.info("BilltemServiceImpl-->bondTransfer()业务接口被调用,共传入,{},条billItemsList,任务ID为,{}", billItemsList.size(), taskId);
        // List<BillItems> billItemsList = queryByList(orderIds);
        //Orders orders = new Orders();
        BigDecimal daiFanglixi = new BigDecimal(0.00);
        BigDecimal jieFanglixi = new BigDecimal(0.00);
        BigDecimal sumlixi = new BigDecimal(0.00);

        BigDecimal payLoanCapital = new BigDecimal(0.00);//应付贷方本金总和
        BigDecimal payLoanInterst = new BigDecimal(0.00);
        BigDecimal payBorrowInterst = new BigDecimal(0.00);
        int size = 0;
        if (!ObjectUtil.isEmpty(billItemsList)) {
            for (BillItems billItems : billItemsList) {
                //应付贷方本金总和
                payLoanCapital = payLoanCapital.add(billItems.getCapital());

                //List<Orders> ordersList = orderService.queryByOrderId(billItems.getOrderId());
                Orders orders = orderService.selectByPrimaryKey(billItems.getOrderId());

                if (!ObjectUtil.isEmpty(orders)) {
                    if (orders.getCompanyRate().doubleValue() == 0.00) {
                        orders.setCompanyRate(new BigDecimal("15"));
                    }

                    BigDecimal activityRate = new BigDecimal(0.00);
                    //周订单的activityRate 存的是月利率,将周订单转换成年化 在进行分润比较
                    if (orders.getFenqiCycle() == 1) {
                        activityRate = (orders.getActivityRate().divide(new BigDecimal("7"), 32, BigDecimal.ROUND_DOWN)).multiply(new BigDecimal("365"));
                    } else {
                        activityRate = orders.getActivityRate();
                    }

                    //判断是否进行分润
                    int i = Utils.needSharePoint(activityRate, orders.getCompanyRate());
                    //i 的返回结果是int类型,-1表示小于,0是等于,1是大于.
                    if (i == 1) {
                        //账单周期类型 1周 2月
                        if (orders.getFenqiCycle() == 2) {
                            //月订单  年利率/12 {坑}  先把 数据库里存的是百分数,先除以100 在
                            BigDecimal lilv = orders.getCompanyRate().divide(new BigDecimal("100")).divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN);
                            //贷方利息 ＝  按照等额本息公式计算出（当期）利息 （ orders－ orginamount ，期数，分润利率 ）
                            Map<Integer, BigDecimal> lixiMap = Utils.getPerMonthInterest(orders.getOrignAmount().doubleValue(), lilv.doubleValue(), orders.getFenqi());
                            daiFanglixi = lixiMap.get(Integer.valueOf(billItems.getOrder()));
                            //贷方利息 > ＝应收利息（bill_item －instest）
                            if (daiFanglixi.doubleValue() >= billItems.getInterest().doubleValue()) {
                                daiFanglixi = billItems.getInterest();
                                jieFanglixi = new BigDecimal("0.00");
                            } else {
                                // 借方利息 = 应收利息-贷方利息
                                jieFanglixi = billItems.getInterest().subtract(daiFanglixi);
                            }
                        } else {
                            //等额本息计算出sumlixi

                            //BigDecimal lilv = (orders.getCompanyRate().divide(new BigDecimal("100")).divide(new BigDecimal("7"), 32, BigDecimal.ROUND_DOWN)).multiply(new BigDecimal("365")).divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN);
                            // BigDecimal lilv = orders.getCompanyRate().divide(new BigDecimal("100")).divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN);
                            //
                            //分润利率(年化)/365*7 算出周利率  用利率带入等额本息. 并且除以12 update by pm tumen.

                            BigDecimal lilv = orders.getCompanyRate().divide(new BigDecimal("100")).divide(new BigDecimal("365"), 32, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("7").divide(new BigDecimal("12"), 32, BigDecimal.ROUND_DOWN));
                            sumlixi = BigDecimal.valueOf(Utils.getInterestCount(orders.getOrignAmount().doubleValue(), lilv.doubleValue(), orders.getFenqi()));
                            //判断是否为最后一期？
                            if (orders.getFenqi() == Integer.valueOf(billItems.getOrder())) {
                                //  贷方末期利息 = sumlixi -［ (sumlixi/期数)*(期数 - 1)］
                                daiFanglixi = sumlixi.subtract((sumlixi.divide(new BigDecimal(orders.getFenqi()), 2, BigDecimal.ROUND_DOWN).multiply((new BigDecimal(orders.getFenqi()).subtract(new BigDecimal("1"))))));
                                if (daiFanglixi.doubleValue() >= billItems.getInterest().doubleValue()) {
                                    daiFanglixi = billItems.getInterest();
                                    jieFanglixi = new BigDecimal("0.00");
                                } else {
                                    jieFanglixi = billItems.getInterest().subtract(daiFanglixi);
                                }

                            } else {
                                //贷方当期利息 =  sumlixi/期数
                                daiFanglixi = sumlixi.divide(new BigDecimal(orders.getFenqi()), 2, BigDecimal.ROUND_DOWN);
                                if (daiFanglixi.doubleValue() >= billItems.getInterest().doubleValue()) {
                                    daiFanglixi = billItems.getInterest();
                                    jieFanglixi = new BigDecimal("0.00");
                                } else {
                                    //贷方当期利息 = 当期应收利息 - 贷方当期利息
                                    jieFanglixi = billItems.getInterest().subtract(daiFanglixi);
                                }
                            }
                        }
                    } else {
                        // 执行利率 < 分润利率
                        //贷方利息 = 应收利息
                        //借方利息 = 应收利息（bill_item －instest ）- 贷方利息-－》结果为（0）
                        daiFanglixi = billItems.getInterest();
                        jieFanglixi = new BigDecimal("0.00");
                    }
                    payLoanInterst = payLoanInterst.add(daiFanglixi);
                    payBorrowInterst = payBorrowInterst.add(jieFanglixi);
                    CsvVO vo = new CsvVO();
                    vo.setBillId(String.valueOf(billItems.getId()));
                    vo.setUserId(String.valueOf(billItems.getUserId()));
                    vo.setOrderId(String.valueOf(billItems.getOrderId()));
                    vo.setCapital(String.valueOf(billItems.getCapital()));
                    vo.setDaifanglixi(String.valueOf(daiFanglixi));
                    vo.setJiefanglixi(String.valueOf(jieFanglixi));
                    vo.setJiefangbutie("");
                    vo.setOverdufine(String.valueOf(billItems.getOverdueFine()));

                    if (ObjectUtil.isNotEmpty(billItems.getDeadline())) {
                        vo.setDedlian(DateUtil.formatToDay2(billItems.getDeadline()));
                    }
                    vo.setLoan_area(String.valueOf(orders.getLoanArea()));
                    vo.setPay_area(String.valueOf(orders.getPayArea()));
                    vo.setCycle_type(String.valueOf(billItems.getCycle()));
                    vo.setFenqi(String.valueOf(orders.getFenqi()));
                    BillItemPaidFlows bipf = new BillItemPaidFlows();
                    bipf.setBillItemId(billItems.getId());
                    bipf.setPayType((byte) 6);
                    List<BillItemPaidFlows> billItemPaidFlowsList = billItemPaidFlowService.query(bipf);
                    // List<BillItemPaidFlows> billItemPaidFlowsList = billItemPaidFlowService.query(bipf);
                    if (!billItemPaidFlowsList.isEmpty()) {
                        BigDecimal paid = new BigDecimal("0.00");
                        for (BillItemPaidFlows bpf : billItemPaidFlowsList) {
                            paid = bpf.getAmount().add(paid);
                        }
                        vo.setPaid(String.valueOf(paid));
                        vo.setPayaccount(billItemPaidFlowsList.get(0).getPayAccount() + "\t");
                        vo.setPaytype(String.valueOf(billItemPaidFlowsList.get(0).getPayType()));
                        vo.setTrade_no(billItemPaidFlowsList.get(0).getTradeNo() + "\t");
                        vo.setReceipt_account(billItemPaidFlowsList.get(0).getReceiptAccount() + "\t");
                        vo.setNotfyTime(DateUtil.formatToDay3(billItemPaidFlowsList.get(0).getPayTime()));
                    } else {
                        vo.setPayaccount("");
                        vo.setReceipt_account("");
                        vo.setPaytype("");
                        vo.setReceipt_account("");
                        logger.info("BillItemPaidFlows 表中无法找到该记录,BillItemId,{}", bipf.getBillItemId());
                    }
                    res.add(vo);
                }
            }
            size = size + billItemsList.size();
            taskService.updateAddById(taskId, payLoanCapital, payLoanInterst, payBorrowInterst, size);

        }
        return res;
    }

    @Override
    public void toFtp(int taskId, List<CsvVO> res, int loanArea, Date date) throws Exception {
        logger.info("BilltemServiceImpl-->toFtp()被调用,传参数{}", taskId);
        String[] str = null;
        TaskInfo record = new TaskInfo();
        String name = DateUtil.formatToDay2(date) + "_" + loanArea;
        String path = DateUtil.formatToDay(date) + "/" + loanArea + "/";
        str = csvSftpService.upLoadToFtp(res, path, name, CsvVO.class);
        record.setId(taskId);
        record.setFilePath(str[0]);
        record.setFileName(str[1]);
        record.setTaskStatus(Constant.taskInfo.task_status_done);
        record.setUpdateTime(new Date());
        taskService.updateByExample(record);
    }


}
