package com.joham.rop;


import com.rop.AbstractRopRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author joham
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WechatLoginSetSaveRopRequest extends AbstractRopRequest {

    /**
     * h5-微信授权登录是否启用 0 不启用， 1 启用
     */
    private Integer mobileServerStatus;

    /**
     * h5-AppID(应用ID)
     */
    private String mobileAppId;

    /**
     * h5-AppSecret(应用密钥)
     */
    private String mobileAppSecret;

    /**
     * pc-微信授权登录是否启用 0 不启用， 1 启用
     */
    private Integer pcServerStatus;

    /**
     * pc-AppID(应用ID)
     */
    private String pcAppId;

    /**
     * pc-AppSecret(应用密钥)
     */
    private String pcAppSecret;

    /**
     * app-微信授权登录是否启用 0 不启用， 1 启用
     */
    private Integer appServerStatus;

    /**
     * 操作人
     */
    private String operatePerson;

}
