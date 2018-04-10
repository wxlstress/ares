package com.qudian.pay.ares.dao.util;


import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import java.util.Properties;

/**
 * sftp 工具类
 *
 * @author wangyunfeng
 */
public class SftpUtils implements Closeable {
    private final static Logger logger = LoggerFactory.getLogger(SftpUtils.class);
    private String host;
    private String username;
    private String password;
    private int port = 22;
    private ChannelSftp sftp = null;
    private Session sshSession = null;

    public SftpUtils() {
    }

    public SftpUtils(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }

    public SftpUtils(String host, String username, String password, int port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    /**
     * connect server via sftp
     */
    public void connect() {
        try {
            JSch jsch = new JSch();
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.setTimeout(120 * 1000);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     */
    public void disconnect() {
        if (this.sftp != null) {
            if (this.sftp.isConnected()) {
                this.sftp.disconnect();
            }
        }
        if (this.sshSession != null) {
            if (this.sshSession.isConnected()) {
                this.sshSession.disconnect();
            }
        }
    }

    /**
     * sftp is connected
     *
     * @return
     */
    public boolean isConnected() {
        return this.sftp != null && this.sftp.isConnected();
    }

    public InputStream downFile(String remotePath, String remoteFile) {
        try {
            if (sftp == null) connect();
            sftp.cd(remotePath);
            return sftp.get(remoteFile);
        } catch (SftpException e) {
            logger.error("文件下载失败或文件不存在！", e);
            e.printStackTrace();
        } finally {
//            disconnect();
        }
        return null;
    }
    
    public byte[] downLoad(String remotePath, String remoteFile) throws Exception{
		try {
            if (sftp == null) connect();
            sftp.cd(remotePath);
            InputStream input =sftp.get(remoteFile);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
    		byte[] buffer = new byte[10485760];
    	    int n = 0;
    	    while (-1 != (n = input.read(buffer))) {
    	        output.write(buffer, 0, n);
    	    }
    	    return output.toByteArray();
        } catch (SftpException e) {
            logger.error("文件下载失败或文件不存在！", e);
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
	}

    /**
     * 下载单个文件
     *
     * @param remoteFileName 下载文件名
     * @param localPath      本地保存目录(以路径符号结束)
     * @param localFileName  保存文件名
     * @return
     */
    public synchronized boolean downloadFile(String remotePath, String remoteFileName,
                                             String localPath, String localFileName) {
        logger.info(remotePath + "/" + remoteFileName + "/" + localPath + "/" + localFileName);
        try {
            if (sftp == null || !isConnected()) {
                connect();
            }
            sftp.cd(remotePath);
            File file = new File(localPath + localFileName);
            mkdirs(localPath + localFileName);
            sftp.get(remoteFileName, new FileOutputStream(file));
            return true;
        } catch (FileNotFoundException e) {
            logger.error("不存在文件,Path:" + remotePath + ",file:" + remoteFileName, e);
        } catch (SftpException e) {
            logger.error("下载文件处理异常,Path:" + remotePath + ",file:" + remoteFileName, e);
        } finally {
            disconnect();
        }

        return false;
    }


    /**
     * 上传
     */

    public void uploadFile(String remotePath, String fileName, InputStream input) throws IOException, Exception {
        try {
            if (sftp == null) {
                connect();
            }
            //createDir(remotePath);
            mkDir(remotePath);
            sftp.put(input, fileName);
        } catch (Exception e) {
            logger.error("文件上传异常！", e);
            throw new Exception("文件上传异常:" + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                }
            }
            disconnect();
        }
    }


    /**
     * 上传单个文件
     *
     * @param remotePath     远程保存目录
     * @param remoteFileName 保存文件名
     * @param localPath      本地上传目录(以路径符号结束)
     * @param localFileName  上传的文件名
     * @return
     */
    public boolean uploadFile(String remotePath, String remoteFileName,
                              String localPath, String localFileName) {
        File fileInput = new File(localPath + localFileName);
        return uploadFile(remotePath, remoteFileName, fileInput);
    }

    /**
     * 上传单个文件
     *
     * @param remotePath     远程保存目录
     * @param remoteFileName 保存文件名
     * @param fileInput      上传的文件
     * @return
     */
    public boolean uploadFile(String remotePath, String remoteFileName, File fileInput) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileInput);
            uploadFile(remotePath, remoteFileName, in);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }





    /**
     * 创建目录
     *
     * @param createpath
     * @return
     */
    private boolean createDir(String createpath) {
        try {
            if (isDirExist(createpath)) {
                this.sftp.cd(createpath);
                return true;
            }
            String pathArry[] = createpath.split("/");
            StringBuffer filePath = new StringBuffer("/");
            for (String path : pathArry) {
                if (path.equals("")) {
                    continue;
                }
                filePath.append(path + "/");
                if (isDirExist(filePath.toString())) {
                    sftp.cd(filePath.toString());
                } else {
                    // 建立目录
                    logger.info("filePath.toString():文件夹路径"+filePath.toString());
                    sftp.mkdir(filePath.toString());
                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }

            }
//			this.sftp.cd(createpath);
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断目录是否存在
     *
     * @param directory
     * @return
     */
    private boolean isDirExist(String directory) {
        boolean isDirExistFlag = false;
        try {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        } catch (Exception e) {
            if (e.getMessage().toLowerCase().equals("no such file")) {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }

    /**
     * 如果目录不存在就创建目录
     *
     * @param path
     */
    private void mkdirs(String path) {
        File f = new File(path);

        String fs = f.getParent();

        f = new File(fs);

        if (!f.exists()) {
            f.mkdirs();
        }
    }

    /**
     * 创建文件夹
     *
     * @param dirName
     */
    public void mkDir(String dirName) {
        String[] dirs = dirName.split("/");
        try {
            String now = sftp.pwd();
            for (int i = 0; i < dirs.length; i++) {
                boolean dirExists = openDir(dirs[i]);
                if (!dirExists) {
                    sftp.mkdir(dirs[i]);
                    sftp.cd(dirs[i]);
                }
            }
            // 进入当前目录
            sftp.cd(now + "/" + dirName);
        } catch (SftpException e) {
            logger.error("mkDir Exception : " + e);
        }
    }

    /**
     * 打开文件夹一层一层
     *
     * @param directory
     * @return
     */

    public boolean openDir(String directory) {
        try {
            sftp.cd(directory);
            return true;
        } catch (SftpException e) {
            logger.error("openDir Exception : " + e);
            return false;
        }
    }

    /**
     * 获取输出的out put stream
     * @param path
     * @param name
     * @return
     * @throws Exception
     */
    public OutputStream getUpLoadStream(String path,String name,String rcCode) throws Exception{
        if (sftp == null || !isConnected()) {
            connect();
        }
        String finalPath = path+rcCode;
        synchronized (CREATE_PATH_LOCK){
            if(!openDir(finalPath)){
                createDir(finalPath);
            }
        }
        sftp.cd(finalPath);
        return sftp.put(name);
    }

    public  OutputStream getUpLoadStream(String path, String name) throws Exception {
        if (sftp == null || !isConnected()) {
            connect();
        }
        synchronized (CREATE_PATH_LOCK) {
            if (!openDir(path)) {
                createDir(path);
            }
        }
        sftp.cd(path);
        return sftp.put(name);
    }

    private static Object CREATE_PATH_LOCK = new Object();


    /**
     * 上传(input上传完成,并未关闭,在外层调用处虚处理)
     */

    public void uploadFile(InputStream input,String remotePath, String fileName) throws IOException, Exception {
        try {
            if (sftp == null) {
                connect();
            }
            if(!openDir(remotePath)){
                createDir(remotePath);
            }

            sftp.put(input, fileName);
        } catch (Exception e) {
            logger.error("文件上传异常！", e);
            throw new Exception("文件上传异常:" + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                }
            }
            disconnect();
        }
    }



    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ChannelSftp getSftp() {
        return sftp;
    }

    public void setSftp(ChannelSftp sftp) {
        this.sftp = sftp;
    }

    @Override
    public void close() throws IOException {
        disconnect();
        System.out.println("close sftp...");
    }

    public static void main(String[] args) {
        SftpUtils sftpUtils = new SftpUtils();
        Properties pop;
        try {
            pop = null;//PropertyUtil.getSftpProperties();
            sftpUtils.setHost(pop.getProperty("SFTP_ADDR"));
            sftpUtils.setPort(Integer.parseInt(pop.getProperty("SFTP_PORT")));
            sftpUtils.setUsername(pop.getProperty("SFTP_USER"));
            sftpUtils.setPassword(pop.getProperty("SFTP_PWD"));
            sftpUtils.downloadFile("/reconciliation/alipay/collect/20160405", "20160405_2088121711571824.zip", "/tmp/reconciliation/unzip/", "20160405_2088121711571824.zip");
            System.out.println("xiazai wancheng");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
