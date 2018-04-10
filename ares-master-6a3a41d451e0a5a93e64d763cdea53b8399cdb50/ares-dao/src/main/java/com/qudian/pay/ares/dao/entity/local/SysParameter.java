package com.qudian.pay.ares.dao.entity.local;

import java.util.Date;

public class SysParameter {
    private Integer id;

    private String sysParameterCode;

    private String sysParameterName;

    private String sysParameterType;

    private Date createTime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysParameterCode() {
        return sysParameterCode;
    }

    public void setSysParameterCode(String sysParameterCode) {
        this.sysParameterCode = sysParameterCode == null ? null : sysParameterCode.trim();
    }

    public String getSysParameterName() {
        return sysParameterName;
    }

    public void setSysParameterName(String sysParameterName) {
        this.sysParameterName = sysParameterName == null ? null : sysParameterName.trim();
    }

    public String getSysParameterType() {
        return sysParameterType;
    }

    public void setSysParameterType(String sysParameterType) {
        this.sysParameterType = sysParameterType == null ? null : sysParameterType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}