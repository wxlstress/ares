package com.qudian.pay.ares.dao.enumeration;

/**
 * Created by zhangdelong on 17/1/18.
 */
public enum TaskTypeEnum {
    DATA_INIT((byte) 0, "数据初始化"),
    TIMER((byte) 1, "定时任务"),
    HANDER((byte) 2, "手动触发");
    private byte code;
    private String name;


    TaskTypeEnum(byte code, String name) {
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
        for (TaskTypeEnum taskInfoEnum : TaskTypeEnum.values()) {
            if (code == (taskInfoEnum.getCode())) {
                return taskInfoEnum.getName();
            }
        }
        return "";
    }
}
