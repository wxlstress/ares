package com.qudian.pay.ares.service.impl;


import com.qudian.pay.ares.dao.dto.CSVParserInterface;
import com.qudian.pay.ares.dao.mapper.local.SysParameterMapper;
import com.qudian.pay.ares.dao.util.CSVName;
import com.qudian.pay.ares.dao.util.CSVParser;
import com.qudian.pay.ares.dao.util.GenerateCode;
import com.qudian.pay.ares.dao.util.SftpUtils;
import com.qudian.pay.ares.dao.vo.FtpAccount;
import com.qudian.pay.ares.service.ICSVSftpService;
import com.qudian.pay.ares.service.cache.StrCache;
import com.qudian.pay.ares.service.enums.EnumInstitution;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by mac on 16/8/19.
 */
@Service

public class CSVSftpServiceImpl implements ICSVSftpService {
    private static Logger logger = LoggerFactory.getLogger(CSVSftpServiceImpl.class);


    private static String DEFAULT_CHARSET = "GBK";

    private static int PACKAGE_SIZE = 200000000;

    private static String _ZIP = ".zip";

    private static String _CSV = ".csv";

    private static String _PART_NAME = "part";

    private static int _BUFF_SIZE = 1024;

//    public static String FTP_PATH = "/data/p2p/";

    @Autowired
    public Environment env;

    private String host;
    private String username;
    private String password;
    private String FTP_PATH ="/data/p2p/ares/";

    private void initSftpParam() {
        FtpAccount ftpAccount= StrCache.ftpAccountMap.get("DEFAULT");
        host = ftpAccount.getHost();
        username = ftpAccount.getUsername();
        password = ftpAccount.getPasswd();
    }


    @Override
    public <T> List<T> getListFromFtp(String path, String fileName, Class<T> clazz) throws Exception {
        List<T> rs = new ArrayList<>();
        try (SftpUtils sftp = createSftp();
             InputStream in = sftp.downFile(path, fileName);) {
            if (fileName.endsWith(_ZIP)) {
                try (ZipInputStream zipIn = new ZipInputStream(in);) {
                    ZipEntry zi = null;
                    while ((zi = zipIn.getNextEntry()) != null) {
                        rs.addAll(CSVParser.parseFormBufferedReader(getReader(zipIn), clazz));
                    }
                }
            } else {
                rs.addAll(CSVParser.parseFormBufferedReader(getReader(in), clazz));
            }
        }
        return rs;
    }


    @Override
    public <T extends CSVParserInterface> String[] upLoadToFtp(List<T> list, String path, String fileName, Class<T> clazz) throws Exception {
        String tempFileName = fileName + ".csv";
        try (SftpUtils sftp = createSftp();
             OutputStream out = sftp.getUpLoadStream(FTP_PATH, tempFileName, path);) {
            String title = getTitle(clazz);
            printCsv(out, list, title);
        }
        return new String[]{FTP_PATH + path, tempFileName};
    }

    @Override
    public <T extends CSVParserInterface> String[] upLoadToFtpForGather(List<T> list, String month, Integer detailId, Class<T> clazz) throws Exception {
        String tempFileName = month + _CSV;
        try (SftpUtils sftp = createSftp();
             OutputStream out = sftp.getUpLoadStream(FTP_PATH, tempFileName, "aprd_" + detailId);) {
            String title = getTitle(clazz);
            if (!tempFileName.endsWith(_ZIP)) {
                printCsv(out, list, title);
            } else {
                printZip(out, list, title);
            }
        }
        return new String[]{FTP_PATH + "aprd_" + detailId, tempFileName};
    }


    @Override
    public SftpUtils getSftp() {
        return createSftp();
    }


    private <T extends CSVParserInterface> void printCsv(OutputStream out, List<T> list, String titile) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, DEFAULT_CHARSET));) {
            bw.write(titile);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null) {
                    bw.newLine();
                    bw.write(getWithoutRN(list.get(i).getCSVString()));
                }
            }
            bw.flush();
        }
    }

    private String getWithoutRN(String str) {
        if (str != null) {
            return str.replaceAll("(\r\n|\n)", "");
        }
        return str;
    }


    private <T extends CSVParserInterface> void printZip(OutputStream out, List<T> list, String titile) throws Exception {
        try (ZipOutputStream zipOut = new ZipOutputStream(out);
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(zipOut, DEFAULT_CHARSET));) {
            int packAgeSize = list.size() % PACKAGE_SIZE == 0 ?
                    list.size() / PACKAGE_SIZE : list.size() / PACKAGE_SIZE + 1;
            for (int i = 0; i < packAgeSize; i++) {
                int begin = i * PACKAGE_SIZE;
                int end = (i + 1) * PACKAGE_SIZE;
                if (i + 1 == packAgeSize) {
                    end = list.size();
                }
                zipOut.putNextEntry(new ZipEntry(_PART_NAME + i + _CSV));
                bw.write(titile);
                for (; begin < end; begin++) {
                    if (list.get(i) != null) {
                        bw.newLine();
                        bw.write(getWithoutRN(list.get(i).getCSVString()));
                    }
                }
                bw.flush();
            }
        }
    }

    private String getTitle(Class<? extends CSVParserInterface> clazz) throws Exception {
        List<String> rs = new ArrayList<>();
        Field[] f = clazz.getDeclaredFields();
        CSVName csv = null;
        for (Field field : f) {
            if ((csv = field.getAnnotation(CSVName.class)) != null) {
                rs.add(csv.value());
            }
        }


        return rs.stream().collect(Collectors.joining(","));

    }


    private SftpUtils createSftp() {

        return new SftpUtils(host, username, password);
    }

    private SftpUtils createSftp(String host,String username,String password,String port) {

        return new SftpUtils(host, username, password,Integer.parseInt(port));
    }


    private static BufferedReader getReader(InputStream in) throws Exception {
//        StringBuilder sb = new StringBuilder();
//        byte[] buf = new byte[_BUFF_SIZE];
//        List<Byte> byteList = new ArrayList<>();
//        int rs = -1;
//        while((rs = in.read(buf)) != -1){
//            fillBuf(byteList,buf,0,rs);
//        }
//        byte[] finalByte = new byte[byteList.size()];
//        copy(byteList,finalByte);
//        for(int i = 0 ; i < commonCsvHead.length ;i++){
//            in.read();//skip 乱码
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET));
//        String tmp = null;
//        while((tmp = br.readLine()) != null){
//            System.out.println(tmp + " .....poo....");
//        }
        return br;
    }

    private static void fillBuf(List<Byte> by, byte[] arr, int begin, int end) {
        for (; begin < end; begin++) {
            by.add(arr[begin]);
        }
    }

    private static void copy(List<Byte> from, byte[] to) {
        for (int i = 0; i < from.size(); i++) {
            to[i] = from.get(i);
        }
    }

    @Override
    public String getFtpPath() {
        return FTP_PATH;
    }

    @Override
    public String uploadFile(String remotePath, String fileName, InputStream input, EnumInstitution enumInstitution) throws Exception {
        FtpAccount ftpAccount = StrCache.ftpAccountMap.get(enumInstitution.getCode());
        SftpUtils sftpUtil = createSftp(ftpAccount.getHost(),ftpAccount.getUsername(),ftpAccount.getPasswd(),ftpAccount.getPort());
            sftpUtil.uploadFile(remotePath, fileName, input);
        return fileName;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2,true);
        for (int i =0;i<100;i++){
            arrayBlockingQueue.offer("str"+i);
        }

       while (true){
           System.out.println(arrayBlockingQueue.take());
       }
    }

}
