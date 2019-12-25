package com.joham.okhttp;

import java.util.HashMap;
import java.util.Map;

public class OkHttpUtilTest {

    public static void main(String[] args) {
        Map<String, String> headersMap = new HashMap<>(16);
        String url = "http://www.xxx.com";
        headersMap.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ" +
                ".eNo0jcEKwjAQRP9lz6XsJptN2nsPBZGi-AExjVBoTKk9KOK_G0XnNszMmydMC7RgXK0Ya2W4JlFQgR_TdO1HaKmCmJY5P2L8WHC-OQcrQYgtNxyQhIQjMosgoi7b25bXb5mUZiPO2MK4lxsy7BoyWqkKuh9071MsWNL4VyEss98ueU0lOJ6GYdd3B3i9AQAA__8.i7wKDryD9FDsBQnGNwk0cvf3ApO_6yxhBo8H0n-4mJg");
//        String result = OkHttpUtil.getSync(url, headersMap);
//        System.out.println(result);
        String json = "{\"pageNum\":0,\"pageSize\":10}";
        String result = OkHttpUtil.postSyncJSON(url, json, headersMap);
        System.out.println(result);
    }
}
