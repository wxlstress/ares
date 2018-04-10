package com.qudian.pay.ares.dao.entity.local;

import java.math.BigDecimal;
import java.util.Date;

public class TaskInfo {
    private Integer id;

    private BigDecimal payLoanCapital;

    private BigDecimal payLoanInterst;

    private BigDecimal payBorrowInterst;

    private Integer orderNum;

    private Integer billItemsNum;

    private Integer taskStatus;

    private Integer taskType;

    private String taskName;

    private String filePath;

    private String fileName;

    private Date repairDate;

    private String errorMsg;

    private String errorDetailedMsg;

    private String ext1;

    private String ext2;

    private String ext3;

    private String ext4;

    private Date createTime;

    private Date updateTime;

    private String operateUser;

    private Integer operateUserId;

    private String createTimeStr;

    private String repairDateStr;

    private String beginCreateDate;
    private String endCreateDate;
    private String beginRepairDate;
    private String endRepairDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPayLoanCapital() {
        return payLoanCapital;
    }

    public void setPayLoanCapital(BigDecimal payLoanCapital) {
        this.payLoanCapital = payLoanCapital;
    }

    public BigDecimal getPayLoanInterst() {
        return payLoanInterst;
    }

    public void setPayLoanInterst(BigDecimal payLoanInterst) {
        this.payLoanInterst = payLoanInterst;
    }

    public BigDecimal getPayBorrowInterst() {
        return payBorrowInterst;
    }

    public void setPayBorrowInterst(BigDecimal payBorrowInterst) {
        this.payBorrowInterst = payBorrowInterst;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getBillItemsNum() {
        return billItemsNum;
    }

    public void setBillItemsNum(Integer billItemsNum) {
        this.billItemsNum = billItemsNum;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg == null ? null : errorMsg.trim();
    }

    public String getErrorDetailedMsg() {
        return errorDetailedMsg;
    }

    public void setErrorDetailedMsg(String errorDetailedMsg) {
        this.errorDetailedMsg = errorDetailedMsg == null ? null : errorDetailedMsg.trim();
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

    public String getOperateUser() {
        return operateUser;
    }

    public void setOperateUser(String operateUser) {
        this.operateUser = operateUser == null ? null : operateUser.trim();
    }

    public Integer getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Integer operateUserId) {
        this.operateUserId = operateUserId;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getRepairDateStr() {
        return repairDateStr;
    }

    public void setRepairDateStr(String repairDateStr) {
        this.repairDateStr = repairDateStr;
    }

    public String getBeginCreateDate() {
        return beginCreateDate;
    }

    public void setBeginCreateDate(String beginCreateDate) {
        this.beginCreateDate = beginCreateDate;
    }

    public String getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(String endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public String getBeginRepairDate() {
        return beginRepairDate;
    }

    public void setBeginRepairDate(String beginRepairDate) {
        this.beginRepairDate = beginRepairDate;
    }

    public String getEndRepairDate() {
        return endRepairDate;
    }

    public void setEndRepairDate(String endRepairDate) {
        this.endRepairDate = endRepairDate;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "id=" + id +
                ", payLoanCapital=" + payLoanCapital +
                ", payLoanInterst=" + payLoanInterst +
                ", payBorrowInterst=" + payBorrowInterst +
                ", orderNum=" + orderNum +
                ", billItemsNum=" + billItemsNum +
                ", taskStatus=" + taskStatus +
                ", taskType=" + taskType +
                ", taskName='" + taskName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", repairDate=" + repairDate +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorDetailedMsg='" + errorDetailedMsg + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", ext4='" + ext4 + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", operateUser='" + operateUser + '\'' +
                ", operateUserId=" + operateUserId +
                ", createTimeStr='" + createTimeStr + '\'' +
                ", repairDateStr='" + repairDateStr + '\'' +
                ", beginCreateDate='" + beginCreateDate + '\'' +
                ", endCreateDate='" + endCreateDate + '\'' +
                ", beginRepairDate='" + beginRepairDate + '\'' +
                ", endRepairDate='" + endRepairDate + '\'' +
                '}';
    }
}