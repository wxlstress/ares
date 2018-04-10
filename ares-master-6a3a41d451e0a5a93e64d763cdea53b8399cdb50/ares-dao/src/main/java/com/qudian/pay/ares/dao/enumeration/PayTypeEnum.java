package com.qudian.pay.ares.dao.enumeration;

/**
 * Created by zhangdelong on 17/1/18.
 * <p>
 * 还款类型枚举
 */
public enum PayTypeEnum {

    NORMAL((byte) 1, "正常还款"),
    BILL_RELIEF((byte) 2, "账单减免"),
    OVERDUE_RELIEF((byte) 3, "滞纳金减免"),
    CUT_RATE((byte) 4, "账单减免");

    private byte code;
    private String name;


    PayTypeEnum(byte code, String name) {
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
        for (PayTypeEnum taskInfoEnum : PayTypeEnum.values()) {
            if (code == (taskInfoEnum.getCode())) {
                return taskInfoEnum.getName();
            }
        }
        return "";
    }
}
