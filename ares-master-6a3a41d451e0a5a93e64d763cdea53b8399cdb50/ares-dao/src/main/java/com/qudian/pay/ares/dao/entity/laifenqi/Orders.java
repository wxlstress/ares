package com.qudian.pay.ares.dao.entity.laifenqi;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer id;

    private String orderNo;

    private Integer userId;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private String newAddress;

    private String mobile;

    private String name;

    private BigDecimal rate;

    private BigDecimal activityRate;

    private Integer status;

    private BigDecimal totalAmount;

    private BigDecimal tipAmount;

    private BigDecimal downPayment;

    private Integer fenqi;

    private BigDecimal perAmount;

    private Byte type;

    private String channel;

    private Byte rateConfigId;

    private BigDecimal orignAmount;

    private String remark;

    private Date cancelAt;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Byte fenqiCycle;

    private Integer payArea;

    private Integer loanArea;

    private Integer shareBenefit;

    private BigDecimal companyRate;

    private Byte tradeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress == null ? null : newAddress.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getActivityRate() {
        return activityRate;
    }

    public void setActivityRate(BigDecimal activityRate) {
        this.activityRate = activityRate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(BigDecimal tipAmount) {
        this.tipAmount = tipAmount;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public Integer getFenqi() {
        return fenqi;
    }

    public void setFenqi(Integer fenqi) {
        this.fenqi = fenqi;
    }

    public BigDecimal getPerAmount() {
        return perAmount;
    }

    public void setPerAmount(BigDecimal perAmount) {
        this.perAmount = perAmount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Byte getRateConfigId() {
        return rateConfigId;
    }

    public void setRateConfigId(Byte rateConfigId) {
        this.rateConfigId = rateConfigId;
    }

    public BigDecimal getOrignAmount() {
        return orignAmount;
    }

    public void setOrignAmount(BigDecimal orignAmount) {
        this.orignAmount = orignAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCancelAt() {
        return cancelAt;
    }

    public void setCancelAt(Date cancelAt) {
        this.cancelAt = cancelAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Byte getFenqiCycle() {
        return fenqiCycle;
    }

    public void setFenqiCycle(Byte fenqiCycle) {
        this.fenqiCycle = fenqiCycle;
    }

    public Integer getShareBenefit() {
        return shareBenefit;
    }

    public void setShareBenefit(Integer shareBenefit) {
        this.shareBenefit = shareBenefit;
    }

    public BigDecimal getCompanyRate() {
        return companyRate;
    }

    public void setCompanyRate(BigDecimal companyRate) {
        this.companyRate = companyRate;
    }

    public Byte getTradeType() {
        return tradeType;
    }

    public void setTradeType(Byte tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getPayArea() {
        return payArea;
    }

    public void setPayArea(Integer payArea) {
        this.payArea = payArea;
    }

    public Integer getLoanArea() {
        return loanArea;
    }

    public void setLoanArea(Integer loanArea) {
        this.loanArea = loanArea;
    }
}