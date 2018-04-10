package com.qudian.pay.ares.service;


import com.qudian.pay.ares.dao.dto.CSVParserInterface;
import com.qudian.pay.ares.dao.util.SftpUtils;
import com.qudian.pay.ares.service.enums.EnumInstitution;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by mac on 16/8/19.
 */
public interface ICSVSftpService {


    <T> List<T> getListFromFtp(String path, String fileName, Class<T> clazz)throws Exception;

    <T extends CSVParserInterface> String[] upLoadToFtp(List<T> list, String path,String fileName,Class<T> clazz)throws Exception;

    <T extends CSVParserInterface> String[] upLoadToFtpForGather(List<T> list, String month, Integer detailId, Class<T> clazz)throws Exception;

    SftpUtils getSftp();

    String getFtpPath();

    String uploadFile(String remotePath, String fileName, InputStream input,EnumInstitution enumInstitution) throws Exception;

}
