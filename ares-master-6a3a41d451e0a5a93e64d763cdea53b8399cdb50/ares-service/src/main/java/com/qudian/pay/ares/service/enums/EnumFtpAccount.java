package com.qudian.pay.ares.service.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午4:51
 * Description:
 */
public enum  EnumFtpAccount {

    DEFAULT("DEFAULT"),
    JIANGXIBANK01(EnumInstitution.JIANGXI.getCode());
    private String code;

    EnumFtpAccount(String code) {
        this.code = code;
    }

    public static List<String> getIns(){
        List<String> stringList =new ArrayList<>();
        for (EnumFtpAccount enumInstitution : EnumFtpAccount.values()) {
            stringList.add(enumInstitution.code);
        }
        return stringList;
    }
}
