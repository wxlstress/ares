package com.qudian.pay.ares.service;

import java.io.File;

/**
 * Created by zhangdelong on 17/1/17.
 */
public interface UtilService {
    public String upLoad2Ftp(String remotePath, String remoteFileName, File fileInput);

    public byte[] downLoad2Ftp(String filePath, String fileName) throws Exception;
}
