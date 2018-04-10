package com.qudian.pay.ares.dao.entity.local;

import java.math.BigDecimal;
import java.util.Date;

public class FinancingCost {
    private Integer id;

    private Byte channelType;

    private String channelName;

    private Integer channelId;

    private Integer channelClassified;

    private Byte repayMethod;

    private BigDecimal repayRate;

    private Date loanDay;

    private Date repayDay;

    private Byte interestType;

    private Integer term;

    private Byte termNumber;

    private BigDecimal loanCapital;

    private BigDecimal yinghuanLixi;

    private BigDecimal shengyuCapital;

    private BigDecimal otherCost;

    private Date createTime;

    private Date updateTime;

    private String optUser;

    private String remark;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

    //date String

    private String loanDayStr;

    private String repayDayStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getChannelType() {
        return channelType;
    }

    public void setChannelType(Byte channelType) {
        this.channelType = channelType;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelClassified() {
        return channelClassified;
    }

    public void setChannelClassified(Integer channelClassified) {
        this.channelClassified = channelClassified;
    }

    public Byte getRepayMethod() {
        return repayMethod;
    }

    public void setRepayMethod(Byte repayMethod) {
        this.repayMethod = repayMethod;
    }

    public BigDecimal getRepayRate() {
        return repayRate;
    }

    public void setRepayRate(BigDecimal repayRate) {
        this.repayRate = repayRate;
    }

    public Date getLoanDay() {
        return loanDay;
    }

    public void setLoanDay(Date loanDay) {
        this.loanDay = loanDay;
    }

    public Date getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Date repayDay) {
        this.repayDay = repayDay;
    }

    public Byte getInterestType() {
        return interestType;
    }

    public void setInterestType(Byte interestType) {
        this.interestType = interestType;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Byte getTermNumber() {
        return termNumber;
    }

    public void setTermNumber(Byte termNumber) {
        this.termNumber = termNumber;
    }

    public BigDecimal getLoanCapital() {
        return loanCapital;
    }

    public void setLoanCapital(BigDecimal loanCapital) {
        this.loanCapital = loanCapital;
    }

    public BigDecimal getYinghuanLixi() {
        return yinghuanLixi;
    }

    public void setYinghuanLixi(BigDecimal yinghuanLixi) {
        this.yinghuanLixi = yinghuanLixi;
    }

    public BigDecimal getShengyuCapital() {
        return shengyuCapital;
    }

    public void setShengyuCapital(BigDecimal shengyuCapital) {
        this.shengyuCapital = shengyuCapital;
    }

    public BigDecimal getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(BigDecimal otherCost) {
        this.otherCost = otherCost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser == null ? null : optUser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }

    public String getLoanDayStr() {
        return loanDayStr;
    }

    public void setLoanDayStr(String loanDayStr) {
        this.loanDayStr = loanDayStr;
    }

    public String getRepayDayStr() {
        return repayDayStr;
    }

    public void setRepayDayStr(String repayDayStr) {
        this.repayDayStr = repayDayStr;
    }
}