package com.qudian.pay.ares.service.utils.exception;

import com.qudian.pay.ares.service.baseService.IResultMessage;
import com.qudian.pay.ares.service.utils.EnumResponse;
import org.apache.commons.lang.ArrayUtils;

import java.text.MessageFormat;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午2:27
 * Description:
 */
public class BusinessException extends RuntimeException {
    private String code;
    private String message;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(EnumResponse enumResponse) {
        this.code = enumResponse.value;
        this.message = enumResponse.desc;
    }

    public BusinessException(EnumResponse enumResponse, Exception e) {
        this.code = enumResponse.value;
        this.message = enumResponse.desc+" ##### e-message："+e.getMessage();
    }

    public <T extends IResultMessage> BusinessException(EnumResponse resultMessage, Object... args) {
        super();

        // 设置错误码
        this.code = resultMessage.getValue();

        String[] arguments = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            arguments[i] = String.valueOf(args[i]);
        }

        this.message = resultMessage.getDesc();
        if (!ArrayUtils.isEmpty(args)) {
            this.message = MessageFormat.format(resultMessage.getDesc(), arguments);
        }
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusinessException{");
        sb.append("code='").append(code).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
