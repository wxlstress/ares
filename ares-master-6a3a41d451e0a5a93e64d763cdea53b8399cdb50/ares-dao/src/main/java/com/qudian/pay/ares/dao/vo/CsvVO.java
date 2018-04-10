package com.qudian.pay.ares.dao.vo;


import com.qudian.pay.ares.dao.dto.CSVParserInterface;
import com.qudian.pay.ares.dao.util.CSVName;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Collectors;


/**
 * Created by qusf on 16/8/16.
 */
public class CsvVO implements Serializable, CSVParserInterface {

    @CSVName("账单Id")
    private String billId;
    @CSVName("用户Id")
    private String userId;
    @CSVName("订单ID")
    private String orderId;//订单ID
    @CSVName("应付贷方本金")
    private String capital;
    @CSVName("应付贷方收入")
    private String daifanglixi;
    @CSVName("应付借方收入")
    private String jiefanglixi;
    @CSVName("借方补贴金额")
    private String jiefangbutie;
    @CSVName("应付借方滞纳金")
    private String overdufine;
    @CSVName("实收用户金额")
    private String paid;
    @CSVName("用户还款帐号")
    private String payaccount;
    @CSVName("用户还款时间")
    private String notfyTime;
    @CSVName("用户还款方式")
    private String paytype;
    @CSVName("用户还款流水号")
    private String trade_no;
    @CSVName("用户应还日期")
    private String dedlian;
    @CSVName("收款账户")
    private String receipt_account;
    @CSVName("贷方公司")
    private String loan_area;
    @CSVName("借方公司")
    private String pay_area;
    @CSVName("分期类型")
    private String cycle_type;
    @CSVName("分期数")
    private String fenqi;


    //本息  考虑用map
    private AtomicReferenceArray<BigDecimal> p2pPayBack;
    //本金
    private AtomicReferenceArray<BigDecimal> p2pBenjin;

    public CsvVO() {
        p2pPayBack = new AtomicReferenceArray<BigDecimal>(24);
        p2pBenjin = new AtomicReferenceArray<BigDecimal>(24);
    }

    public CsvVO(Boolean needInit) {
        if (needInit) {
            p2pPayBack = new AtomicReferenceArray<BigDecimal>(24);
            p2pBenjin = new AtomicReferenceArray<BigDecimal>(24);
        }
    }


    public static String[] getTitlesx(Class<? extends CSVParserInterface> clazz) {
        List<String> rs = new ArrayList<>();
        Field[] f = clazz.getDeclaredFields();
        CSVName csv = null;
        for (Field field : f) {
            if ((csv = field.getAnnotation(CSVName.class)) != null) {
                rs.add(csv.value());
            }
        }
        String[] rsc = new String[rs.size()];
        return rs.toArray(rsc);
    }

    public static void main(String[] args) {
        List<String> l = Arrays.asList(getTitlesx(CsvVO.class));
//        l.forEach(System.out::println);
        System.out.println(l.stream().collect(Collectors.joining(",")));
    }


    @Override
    public String getCSVString() {
        return billId + "," + userId + "," + orderId + "," + capital + "," + daifanglixi + "," + jiefanglixi + "," + jiefangbutie + "," + overdufine + "," + paid + "," + payaccount + "," + notfyTime + "," + paytype + "," + trade_no + "," + dedlian + "," + receipt_account + "," + loan_area + "," + pay_area + "," + cycle_type + "," + fenqi;
    }

    @Override
    public String[] getTitle() {
        return new String[0];
    }


    private String getAtomicRefString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p2pPayBack.length(); i++) {
            BigDecimal b = p2pPayBack.get(i);               //这里加了\t是为了让csv不丢失精度  大坑也
            sb.append(b == null ? "0" : b.toString()).append("\t").append(",");
        }
        for (int i = 0; i < p2pBenjin.length(); i++) {
            BigDecimal b = p2pBenjin.get(i);
            sb.append(b == null ? "0" : b.toString()).append("\t").append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getDaifanglixi() {
        return daifanglixi;
    }

    public void setDaifanglixi(String daifanglixi) {
        this.daifanglixi = daifanglixi;
    }

    public String getJiefanglixi() {
        return jiefanglixi;
    }

    public void setJiefanglixi(String jiefanglixi) {
        this.jiefanglixi = jiefanglixi;
    }

    public String getJiefangbutie() {
        return jiefangbutie;
    }

    public void setJiefangbutie(String jiefangbutie) {
        this.jiefangbutie = jiefangbutie;
    }

    public String getOverdufine() {
        return overdufine;
    }

    public void setOverdufine(String overdufine) {
        this.overdufine = overdufine;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPayaccount() {
        return payaccount;
    }

    public void setPayaccount(String payaccount) {
        this.payaccount = payaccount;
    }

    public String getNotfyTime() {
        return notfyTime;
    }

    public void setNotfyTime(String notfyTime) {
        this.notfyTime = notfyTime;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getDedlian() {
        return dedlian;
    }

    public void setDedlian(String dedlian) {
        this.dedlian = dedlian;
    }

    public String getReceipt_account() {
        return receipt_account;
    }

    public void setReceipt_account(String receipt_account) {
        this.receipt_account = receipt_account;
    }

    public String getLoan_area() {
        return loan_area;
    }

    public void setLoan_area(String loan_area) {
        this.loan_area = loan_area;
    }

    public String getPay_area() {
        return pay_area;
    }

    public void setPay_area(String pay_area) {
        this.pay_area = pay_area;
    }

    public String getCycle_type() {
        return cycle_type;
    }

    public void setCycle_type(String cycle_type) {
        this.cycle_type = cycle_type;
    }

    public String getFenqi() {
        return fenqi;
    }

    public void setFenqi(String fenqi) {
        this.fenqi = fenqi;
    }

    public AtomicReferenceArray<BigDecimal> getP2pPayBack() {
        return p2pPayBack;
    }

    public void setP2pPayBack(AtomicReferenceArray<BigDecimal> p2pPayBack) {
        this.p2pPayBack = p2pPayBack;
    }

    public AtomicReferenceArray<BigDecimal> getP2pBenjin() {
        return p2pBenjin;
    }

    public void setP2pBenjin(AtomicReferenceArray<BigDecimal> p2pBenjin) {
        this.p2pBenjin = p2pBenjin;
    }

}
