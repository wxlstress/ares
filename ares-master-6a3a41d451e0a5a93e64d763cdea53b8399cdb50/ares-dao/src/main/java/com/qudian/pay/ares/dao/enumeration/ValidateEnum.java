package com.qudian.pay.ares.dao.enumeration;

/**
 * Created by zhangdelong on 16/8/24.
 */
public enum ValidateEnum {
//    private final static String notNull ="不能为空";
//    private final static String formatError ="格式错误";
    NotNull(01,"不能为空"),
    formatError(02,"格式错误"),;

    private Integer code;
    private String name;
    private ValidateEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
