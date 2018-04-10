package com.qudian.pay.ares.service.baseService;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午2:28
 * Description:
 */
public interface IResultMessage {
    /**
     * 获取错误码
     * @return
     */
    String getValue();

    /**
     * 获取错误信息
     * @return
     */
    String getDesc();
}
