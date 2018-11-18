package com.joham.ftp;

import lombok.Data;

/**
 * ftp配置文件
 *
 * @author joham
 */
@Data
public class FtpConfig {

    /**
     * ftp ip地址
     */
    private String ftpAddress;

    /**
     * 端口号
     */
    private int ftpPort;

    /**
     * 用户名
     */
    private String ftpUsername;

    /**
     * 密码
     */
    private String ftpPassword;

    /**
     * 基本路径
     */
    private String ftpBasePath;

    /**
     * 下载地址基础url
     */
    private String imageBaseUrl;

}

