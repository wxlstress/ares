package com.qudian.pay.ares.dao.enumeration;

/**
 * Created by zhangdelong on 17/1/18.
 */
public enum TaskStatusEnum {
    TASK_INIT((byte) 0, "初始化"),
    TASK_DONE((byte) 1, "已完成"),
    TASK_FAILE((byte) 2, "失败"),
    TASK_TMP((byte) 3, "临时");
    private byte code;
    private String name;


    TaskStatusEnum(byte code, String name) {
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
        for (TaskStatusEnum taskInfoEnum : TaskStatusEnum.values()) {
            if (code == (taskInfoEnum.getCode())) {
                return taskInfoEnum.getName();
            }
        }
        return "";
    }
}
