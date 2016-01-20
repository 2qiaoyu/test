package com.joham.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joham on 2016/1/19.
 */
public class TsetFastJson {
    public static void main(String[] args) {
        map2JSON();
    }

    public static void map2JSON(){
        Map map = new HashMap();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");
        String json= JSON.toJSONString(map);
        System.out.println(json);
        Map map1 = JSON.parseObject(json);
        for (Object o : map1.entrySet()) {
            Map.Entry<String,String> entry = (Map.Entry<String,String>)o;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
    }
}
