package com.joham.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ftp上传测试
 *
 * @author joham
 */
public class FtpTest {

    /**
     * ftp ip地址
     */
    private static final String FTP_ADDRESS = "172.19.26.240";

    /**
     * 基本路径
     */
    private static final String FTP_BASE_PATH = "/";

    /**
     * 用户名
     */
    private static final String FTP_USERNAME = "qianmi";

    /**
     * 密码
     */
    private static final String FTP_PASSWORD = "qianmi";

    /**
     * 端口号
     */
    private static final int FTP_PORT = 21;

    /**
     * 下载地址基础url
     */
    private static final String IMAGE_BASE_URL = "http://172.19.26.240/";

    public static void main(String[] args) throws IOException {
        FtpConfig ftpConfig = new FtpConfig();
        ftpConfig.setFtpAddress(FTP_ADDRESS);
        ftpConfig.setFtpBasePath(FTP_BASE_PATH);
        ftpConfig.setFtpPassword(FTP_PASSWORD);
        ftpConfig.setFtpUsername(FTP_USERNAME);
        ftpConfig.setFtpPort(FTP_PORT);
        ftpConfig.setImageBaseUrl(IMAGE_BASE_URL);
        File file = new File("/Users/joham/Pictures/00.jpg");
        InputStream inputStream = new FileInputStream(file);
        FtpUtil.pictureUploadByConfig(ftpConfig,
                "test1.png", "images", inputStream);
        FtpUtil.downloadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
                "/images/", "test1.png", "/Users/joham/Downloads/");
    }
}
