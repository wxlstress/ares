package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.service.ICSVSftpService;
import com.qudian.pay.ares.service.UtilService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created by zhangdelong on 17/1/17.
 */
@Service
public class UtilServiceImpl implements UtilService {
    @Resource
    ICSVSftpService icsvSftpService;

    @Override
    public String upLoad2Ftp(String remotePath, String remoteFileName, File fileInput) {
        return null;
    }

    @Override
    public byte[] downLoad2Ftp(String filePath, String fileName) throws Exception {
        return icsvSftpService.getSftp().downLoad(filePath, fileName);
    }
}
