package com.joham.elasticsearch;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 版本
 */

@Data
@AllArgsConstructor
public class Version {

    /**
     * 操作系统：ios、android
     */
    private String os;

    /**
     * 版本号
     */
    private String version;

    /**
     * 发布时间
     */
    private Long releaseTime;

    /**
     * 下载地址
     */
    private String url;

    /**
     * 描述信息
     */
    private String description;

}
