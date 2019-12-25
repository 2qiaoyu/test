package com.joham.rop;

import com.alibaba.fastjson.JSON;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.client.RopClient;

/**
 * @author joham
 */
public class RopUtil {

    private static RopClient ropClient = new DefaultRopClient("http://localhost:8080/open_app_war_exploded/router",
            "wm_xIIL4hOa", "1b84db023af345dca1cb81d8ceb7373a");


    public static void main(String[] args) throws Exception {
//        CompositeResponse response = ropClient.buildClientRequest().get(WechatLoginSetRopResponse.class, "wechat.login" +
//                ".querySetDetail", "1.0.0");
//        WechatLoginSetSaveRopRequest wechatLoginSetSaveRopRequest = new WechatLoginSetSaveRopRequest();
//        wechatLoginSetSaveRopRequest.setAppServerStatus(1);
//        wechatLoginSetSaveRopRequest.setMobileAppId("wxf7e90ffd3bee627a");
//        wechatLoginSetSaveRopRequest.setMobileAppSecret("c816a6ac02d5265a333033b88a3f3c25");
//        wechatLoginSetSaveRopRequest.setMobileServerStatus(1);
//        wechatLoginSetSaveRopRequest.setPcServerStatus(1);
//        wechatLoginSetSaveRopRequest.setPcAppId("wxf7e90ffd3bee627a");
//        wechatLoginSetSaveRopRequest.setPcAppSecret("c816a6ac02d5265a333033b88a3f3c25");
//        CompositeResponse<BaseRopResponse> response = ropClient.buildClientRequest().post(wechatLoginSetSaveRopRequest,
//                BaseRopResponse.class,
//                "wechat.login" +
//                        ".saveLoginSet", "1.0.0");
        WechatShareSetSaveRopRequest  request = new WechatShareSetSaveRopRequest();
        request.setOperatePerson("joham");
        request.setShareAppId("111");
        request.setShareAppSecret("2222");
        ropClient.buildClientRequest().post(request, WechatShareSetRopResponse.class, "wechat.share.save", "1.0.0");
//        System.out.println(JSON.toJSONString(response));
    }
}
