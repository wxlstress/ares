package com.qudian.pay.ares.dao.entity.local;

import java.util.Date;

public class BankFileUpload {
    private Integer id;

    private String insName;

    private String loandetail;

    private String payplan;

    private String paylog;

    private String indemnity;

    private String overdue;

    private Date uploadTime;

    private String optName;

    private Date createTime;

    private Date updateTime;

    private String createTimeStr;

    private String updateTimeStr;

    private String uploadTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName == null ? null : insName.trim();
    }

    public String getLoandetail() {
        return loandetail;
    }

    public void setLoandetail(String loandetail) {
        this.loandetail = loandetail == null ? null : loandetail.trim();
    }

    public String getPayplan() {
        return payplan;
    }

    public void setPayplan(String payplan) {
        this.payplan = payplan == null ? null : payplan.trim();
    }

    public String getPaylog() {
        return paylog;
    }

    public void setPaylog(String paylog) {
        this.paylog = paylog == null ? null : paylog.trim();
    }

    public String getIndemnity() {
        return indemnity;
    }

    public void setIndemnity(String indemnity) {
        this.indemnity = indemnity == null ? null : indemnity.trim();
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue == null ? null : overdue.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName == null ? null : optName.trim();
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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getUpdateTimeStr() {
        return updateTimeStr;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getUploadTimeStr() {
        return uploadTimeStr;
    }

    public void setUploadTimeStr(String uploadTimeStr) {
        this.uploadTimeStr = uploadTimeStr;
    }
}