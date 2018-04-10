package com.qudian.pay.ares.dao.enumeration;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhangdelong on 17/1/18.
 */
public enum TaskNameEnum {
    gzxdwjs("29", "赣州小贷-网金社"),
    zhaizhuan("0", "债权转让"),
    fzxdwjs("49", "抚州小贷-网金社");
    private String code;
    private String name;

    private TaskNameEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNameByCode(String code) {
        if (StringUtils.isBlank(code)) return null;
        for (TaskNameEnum accountInfoEnum : TaskNameEnum.values()) {
            if (code.equals(accountInfoEnum.getCode())) {
                return accountInfoEnum.getName();
            }
        }
        return null;
    }

    public static String getCodeByName(String name) {
        if (StringUtils.isBlank(name)) return null;
        for (TaskNameEnum accountInfoEnum : TaskNameEnum.values()) {
            if (name.equals(accountInfoEnum.getName())) {
                return accountInfoEnum.getCode();
            }
        }
        return null;
    }
}
