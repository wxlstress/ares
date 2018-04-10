package com.qudian.pay.ares.dao.vo;

/**
 * Created with IntelliJ IDEA.
 * User: zhangdelong
 * Date: 18/3/26
 * Time: 下午4:42
 * Description:
 */
public class FtpAccount {
    //用户名
    private String username;
    //密码
    private String passwd;
    //端口
    private String port;
    //url链接
    private String host;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
