package com.joham.httpclient;

import com.alibaba.fastjson.JSON;
import com.joham.date.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joham
 */
public class TestHttpClient {

    public static void main(String[] args) {
        String timestamp = DateUtil.DateToString(new Date(), "yyyyMMddHHmm");
        String appUserName = "yijiaosuo";
        String key = "VKVCGCMLFEUQGSHRCWFI";
        String token = "WJJFHEAFZGGCPWXTBINVGLYAYMLMMW";
//        String sign = MD5Util.md5Hex(appUserName + timestamp + key);
//        String url = "http://localhost:8083/boss/token.htm?appUserName=" + appUserName + "&sign=" + sign + "&timestamp="
//                + timestamp;
//        HttpClientUtil.get(url, null);

//        String sign = MD5Util.md5Hex(appUserName + timestamp + token + key);
//        String url = "http://120.27.249.175:7300/boss/addArtist.htm";
//        Map<String, Object> paramMap = new HashMap<>(16);
//        paramMap.put("sign", sign);
//        paramMap.put("appUserName", appUserName);
//        paramMap.put("token", token);
//        paramMap.put("name", "fdgfsd");
//        paramMap.put("sex", "0");
//        paramMap.put("area", "北京");
//        paramMap.put("enabled", "1");
//        paramMap.put("enterTime", "20180604111632");
//        paramMap.put("timestamp", timestamp);
//        String param = JSON.toJSONString(paramMap);
//        String result = HttpClientUtil.jsonPost(url, null, param);
//        Result result1 = JSON.parseObject(result, Result.class);
//        System.out.println(result1.getArtistId());

//        String sign = MD5Util.md5Hex(appUserName + timestamp + token + key);
        String url = "http://120.27.249.175:7300/boss/addArtist.htm";
//        Map<String, Object> paramMap = new HashMap<>(16);
//        paramMap.put("artistId", 3);
//        paramMap.put("sign", sign);
//        paramMap.put("appUserName", appUserName);
//        paramMap.put("token", token);
//        paramMap.put("name", "徐薇");
//        paramMap.put("sex", "1");
//        paramMap.put("area", "北京");
//        paramMap.put("enabled", "1");
//        paramMap.put("enterTime", "20180604111632");
//        paramMap.put("timestamp", timestamp);
//        String param = JSON.toJSONString(paramMap);
        String json = "{\"area\":\"承德\",\"sex\":0,\"name\":\"dsfsd\",\"sign\":\"c9604fba8b17f6c2ff7defd62e70cc64\",\"appUserName\":\"yijiaosuo\",\"enabled\":1,\"enterTime\":\"20180613144206\",\"token\":\"UNUZVMGKGWCAIVDWXEAVGJFFEHHTXF\",\"timestamp\":\"201806131442\"}";
        String result = HttpClientUtil.jsonPost(url, null, json);
    }
}
