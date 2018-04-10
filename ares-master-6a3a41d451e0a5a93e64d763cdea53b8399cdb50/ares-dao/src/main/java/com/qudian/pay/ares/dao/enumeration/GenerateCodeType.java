package com.qudian.pay.ares.dao.enumeration;

/**
 * 随机码扩展字段
 * Created by lp on 16/8/15.
 */
public  enum GenerateCodeType {

    P2P_PACKAGE("000"), ABS_OTHER("001");

    private String type;

    GenerateCodeType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
