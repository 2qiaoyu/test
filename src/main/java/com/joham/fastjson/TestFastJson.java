package com.joham.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

/**
 * fastjson map,list使用
 * Created by joham on 2016/1/19.
 */
public class TestFastJson {
    public static void main(String[] args) {
//        test();
//        test1();
//        map2JSON();
//        list2JSON();
        test2();
    }

    /**
     * 类转换为json
     */
    public static void test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("joham");
        userInfo.setAge(18);
        System.out.println(JSON.toJSON(userInfo));
    }

    /**
     * 解析json成类
     */
    public static void test1() {
        String json = "{\"name\":\"joham\",\"age\":18}";
        UserInfo userInfo = JSON.parseObject(json, UserInfo.class);
        System.out.println(userInfo.getName() + "---" + userInfo.getAge());
    }

    /**
     * map，json互转
     */
    public static void map2JSON() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        String json = JSON.toJSONString(map);
        System.out.println(json);
        Map map1 = JSON.parseObject(json);
        for (Object o : map1.entrySet()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    /**
     * list，json互转
     */
    public static void list2JSON() {
        List<Object> list = new ArrayList<Object>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        String json = JSON.toJSONString(list);
        System.out.println(json);
        List<Object> list1 = JSON.parseObject(json, new TypeReference<List<Object>>() {
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    /**
     * 日期格式化
     */
    public static void test2(){
        Date date = new Date();
        String json = JSON.toJSONString(date);
        System.out.println(json);
        System.out.println(JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));
        System.out.println(JSON.toJSONStringWithDateFormat(date,"yyyy-MM-dd",SerializerFeature.WriteDateUseDateFormat));
    }
}
