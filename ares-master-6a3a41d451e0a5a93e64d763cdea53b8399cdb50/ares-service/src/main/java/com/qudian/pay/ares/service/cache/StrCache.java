package com.qudian.pay.ares.service.cache;

import com.qudian.pay.ares.dao.vo.FtpAccount;
import com.qudian.pay.ares.service.enums.EnumFtpAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午4:41
 * Description:
 */
@Component
@PropertySource("classpath:config/ftp.properties")
public class StrCache {

    @Autowired
    private Environment env;

    public static Map<String, FtpAccount> ftpAccountMap = new HashMap<>();

    @PostConstruct
    private void init() {
        List<String> list = EnumFtpAccount.getIns();
        for (String s : list) {
            FtpAccount ftpAccount = new FtpAccount();
            ftpAccount.setHost(env.getProperty(s + ".FTP.HOST"));
            ftpAccount.setUsername(env.getProperty(s + ".FTP.USERNAME"));
            ftpAccount.setPasswd(env.getProperty(s + ".FTP.PASSWORD"));
            ftpAccount.setPort(env.getProperty(s + ".FTP.PORT"));
            ftpAccountMap.put(s,ftpAccount);
        }
    }
}
