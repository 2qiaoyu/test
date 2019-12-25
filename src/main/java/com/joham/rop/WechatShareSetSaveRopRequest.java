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
public class WechatShareSetSaveRopRequest extends AbstractRopRequest {

    /**
     * 微信分享 AppId
     */
    private String shareAppId;

    /**
     * 微信分享 Secret
     */
    private String shareAppSecret;

    /**
     * 操作人
     */
    private String operatePerson;

}
