package com.qudian.pay.ares.service.utils;

import com.qudian.pay.ares.service.baseService.IResultMessage;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午2:24
 * Description:
 */
public enum  EnumResponse implements IResultMessage{

    /**
     * 成功
     */
    SUCCESS("200", "成功"),
    DEALING("666666", "处理中"),
    SYSTEM_ERROR("200000", "系统异常"),;

    public  String value;
    public  String desc;

    EnumResponse(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
