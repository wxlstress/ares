package com.qudian.pay.ares.dao.dto;

import java.util.Date;

/**
 * Created by youzhijie on 17/6/5.
 */
public class CostOriginVo {
    private Integer id;

    private int loanCompany;

    private int businessCompany;

    private String origin;

    private Integer natureOfFundsId;

    private String natureOfFunds;

    private Date createTime;

    private Date updateTime;

    private String optUser;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLoanCompany() {
        return loanCompany;
    }

    public void setLoanCompany(int loanCompany) {
        this.loanCompany = loanCompany;
    }

    public int getBusinessCompany() {
        return businessCompany;
    }

    public void setBusinessCompany(int businessCompany) {
        this.businessCompany = businessCompany;
    }

    public void setBusinessCompany(Byte businessCompany) {
        this.businessCompany = businessCompany;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Integer getNatureOfFundsId() {
        return natureOfFundsId;
    }

    public void setNatureOfFundsId(Integer natureOfFundsId) {
        this.natureOfFundsId = natureOfFundsId;
    }

    public String getNatureOfFunds() {
        return natureOfFunds;
    }

    public void setNatureOfFunds(String natureOfFunds) {
        this.natureOfFunds = natureOfFunds == null ? null : natureOfFunds.trim();
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

    @Override
    public String toString() {
        return "CostOriginVo{" +
                "id=" + id +
                ", loanCompany=" + loanCompany +
                ", businessCompany=" + businessCompany +
                ", origin='" + origin + '\'' +
                ", natureOfFundsId=" + natureOfFundsId +
                ", natureOfFunds='" + natureOfFunds + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", optUser='" + optUser + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", ext4='" + ext4 + '\'' +
                '}';
    }
}
