package com.qudian.pay.ares.dao.dto;

import com.qudian.pay.ares.dao.annotation.ReportAnnotation;

import java.math.BigDecimal;
import java.util.Date;

public class FinancingCostVo {

    private Integer id;

    @ReportAnnotation(name = "渠道类型")
    private Byte channelType;

    @ReportAnnotation(name = "渠道名称")
    private String channelName;

    private Integer channelId;

    @ReportAnnotation(name = "渠道分类")
    private Integer channelClassified;

    @ReportAnnotation(name = "还款方式")
    private Byte repayMethod;

    @ReportAnnotation(name = "还款利率")
    private BigDecimal repayRate;

    @ReportAnnotation(name = "放款日")
    private String loanDayStr;
    @ReportAnnotation(name = "还款日")
    private String repayDayStr;
    @ReportAnnotation(name = "计息类型")
    private Byte interestType;
    @ReportAnnotation(name = "期限")

    private Integer term;
    @ReportAnnotation(name = "还款期次")
    private Byte termNumber;
    @ReportAnnotation(name = "放款金额")
    private BigDecimal loanCapital;
    @ReportAnnotation(name = "应还利息")
    private BigDecimal yinghuanLixi;
    @ReportAnnotation(name = "剩余本金")
    private BigDecimal shengyuCapital;
    @ReportAnnotation(name = "其他费用")
    private BigDecimal otherCost;

    private Date createTime;

    private Date updateTime;
    @ReportAnnotation(name = "操作人")
    private String optUser;

    private String remark;

    @ReportAnnotation(name = "状态")
    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private String ext5;

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
        this.channelName = channelName;
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
        this.channelClassified=channelClassified;

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
        this.optUser = optUser;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    @Override
    public String toString() {
        return "FinancingCostVo{" +
                "id=" + id +
                ", channelType=" + channelType +
                ", channelName='" + channelName + '\'' +
                ", channelId=" + channelId +
                ", channelClassified=" + channelClassified +
                ", repayMethod=" + repayMethod +
                ", repayRate=" + repayRate +
                ", loanDayStr='" + loanDayStr + '\'' +
                ", repayDayStr='" + repayDayStr + '\'' +
                ", interestType=" + interestType +
                ", term=" + term +
                ", termNumber=" + termNumber +
                ", loanCapital=" + loanCapital +
                ", yinghuanLixi=" + yinghuanLixi +
                ", shengyuCapital=" + shengyuCapital +
                ", otherCost=" + otherCost +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", optUser='" + optUser + '\'' +
                ", remark='" + remark + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", ext4='" + ext4 + '\'' +
                ", ext5='" + ext5 + '\'' +
                '}';
    }
}