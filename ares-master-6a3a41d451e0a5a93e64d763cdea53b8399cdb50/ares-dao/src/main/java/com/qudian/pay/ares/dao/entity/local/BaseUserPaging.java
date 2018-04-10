package com.qudian.pay.ares.dao.entity.local;

import java.util.Date;

public class BaseUserPaging {
    private Integer id;

    private Byte isEnd;

    private Integer totals;

    private String previous;

    private String isStart;

    private String next;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Byte isEnd) {
        this.isEnd = isEnd;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous == null ? null : previous.trim();
    }

    public String getIsStart() {
        return isStart;
    }

    public void setIsStart(String isStart) {
        this.isStart = isStart == null ? null : isStart.trim();
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next == null ? null : next.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}