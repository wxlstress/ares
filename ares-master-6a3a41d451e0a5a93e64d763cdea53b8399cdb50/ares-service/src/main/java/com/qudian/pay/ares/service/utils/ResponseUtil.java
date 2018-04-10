package com.qudian.pay.ares.service.utils;

import com.google.common.collect.Maps;
import com.qudian.pay.ares.service.utils.exception.BusinessException;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午2:22
 * Description:
 */
public class ResponseUtil {

    /**
     * 定义返回的key值
     */
    public static final String CODE = "code";
    public static final String MESSAGE = "msg";
    public static final String DATA = "data";

    public static Map<String, Object> bulidMap(String code, String message, Object object) {
        Map<String, Object> map = Maps.newHashMap();
        map.put(CODE, code);
        map.put(MESSAGE, message);
        map.put(DATA, object);
        return map;
    }

    public static Map<String, Object> bulidMap(String code, String message) {
        Map<String, Object> map = Maps.newHashMap();
        map.put(CODE, code);
        map.put(MESSAGE, message);
        return map;
    }

    public static Map<String, Object> buildSuccess() {
        return bulidMap(EnumResponse.SUCCESS.value, EnumResponse.SUCCESS.desc);
    }

    public static Map<String, Object> buildFinished() {
        return bulidMap(EnumResponse.DEALING.value, EnumResponse.DEALING.desc);
    }

    public static Map<String, Object> buildSuccess(Object object) {
        return bulidMap(EnumResponse.SUCCESS.value, EnumResponse.SUCCESS.desc, object);
    }

    public static Map<String, Object> buildError() {
        return bulidMap(EnumResponse.SYSTEM_ERROR.value, EnumResponse.SYSTEM_ERROR.desc);
    }

    public static Map<String, Object> buildSystemError(String message) {
        return bulidMap(EnumResponse.SYSTEM_ERROR.value, message);
    }

    public static Map<String, Object> build(EnumResponse response) {
        return bulidMap(response.value, response.desc);
    }

    public static Map<String, Object> build(BusinessException be) {
        return bulidMap(be.getCode(), be.getMessage());
    }

    public static Map<String, Object> build(EnumResponse response, Object data) {
        return bulidMap(response.value, response.desc, data);
    }
}
