package com.qudian.pay.ares.dao.enumeration;

/**
 * Created by zhangdelong on 17/1/18.
 * <p>
 * 账单周期类型枚举
 */
public enum BilIItemsCycleEnum {
    WEEK((byte) 1, "周"),
    MONTH((byte) 2, "月");
    private byte code;
    private String name;

    BilIItemsCycleEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByCode(Byte code) {
//        if(StringUtils.isBlank(code))
//            return null;
        if (code == 0 && code == null)
            return "";
        for (BilIItemsCycleEnum taskInfoEnum : BilIItemsCycleEnum.values()) {
            if (code == (taskInfoEnum.getCode())) {
                return taskInfoEnum.getName();
            }
        }
        return "";
    }
}


