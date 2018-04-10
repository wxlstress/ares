package com.qudian.pay.ares.dao.entity.local;

import java.util.Date;

public class Channel {
    private Long id;

    private Integer loanCompany;

    private Integer businessCompany;

    private String channelName;

    private Byte channelStatus;

    private Date createTime;

    private Date updateTime;

    private String ext1;

    private String ext2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLoanCompany() {
        return loanCompany;
    }

    public void setLoanCompany(Integer loanCompany) {
        this.loanCompany = loanCompany;
    }

    public Integer getBusinessCompany() {
        return businessCompany;
    }

    public void setBusinessCompany(Integer businessCompany) {
        this.businessCompany = businessCompany;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public Byte getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Byte channelStatus) {
        this.channelStatus = channelStatus;
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
}