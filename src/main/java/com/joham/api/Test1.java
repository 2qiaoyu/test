package com.joham.api;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by joham on 2016/3/7.
 */
public class Test1 {
    public static void main(String[] args) {
        String result = "{\"data\":{\"sign\":null,\"client_id\":null,\"return_param\":null,\"request_token\":null,\"redirect_url\":null},\"resp_code\":\"0000\",\"resp_msg\":\"登录信息异常，请重新登录！\"}";
        Map<String, Object> map = getMapFromJson(result);
        String requestToken = "";
        if(map.get("resp_code").equals("0000")){
            Map<String, Object> map1 = getMapFromJson(map.get("data").toString());
            requestToken = map1.get("request_token").toString();
        }
        System.out.println(requestToken);
    }

    public static Map<String, Object> getMapFromJson(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Iterator<?> iter = jsonObject.keys(); iter.hasNext(); ) {
            String key = (String) iter.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }
}
