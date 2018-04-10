package com.qudian.pay.ares.service;

import com.qudian.pay.ares.dao.entity.local.BankFileUpload;
import com.qudian.pay.ares.service.baseService.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午2:18
 * Description:
 */
public interface BankFileService extends IBaseService<BankFileUpload> {
    Object uploadAndSaveFile(String json);
}
