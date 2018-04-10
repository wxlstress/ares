package com.qudian.pay.ares.dao.entity.local;

import java.util.Date;

public class PushPlatform {
    private Integer id;

    private String pushMethod;

    private String collaborationPlatform;

    private Integer platformId;

    private String pushState;

    private String platformClassification;

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

    public String getPushMethod() {
        return pushMethod;
    }

    public void setPushMethod(String pushMethod) {
        this.pushMethod = pushMethod == null ? null : pushMethod.trim();
    }

    public String getCollaborationPlatform() {
        return collaborationPlatform;
    }

    public void setCollaborationPlatform(String collaborationPlatform) {
        this.collaborationPlatform = collaborationPlatform == null ? null : collaborationPlatform.trim();
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPushState() {
        return pushState;
    }

    public void setPushState(String pushState) {
        this.pushState = pushState == null ? null : pushState.trim();
    }

    public String getPlatformClassification() {
        return platformClassification;
    }

    public void setPlatformClassification(String platformClassification) {
        this.platformClassification = platformClassification == null ? null : platformClassification.trim();
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
}