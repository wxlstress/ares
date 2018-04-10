package com.qudian.pay.ares.dao.dto;

import com.qudian.pay.ares.dao.entity.local.TaskInfo;

import java.util.List;

public class TaskInfoExt extends TaskInfo {
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
