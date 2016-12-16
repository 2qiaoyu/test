package com.joham.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * fastJson使用
 */
public class TestFastJson {
    public static void main(String[] args) {
        javaBeanToJson();
        listToJson();
        mapToJson();
    }

    /**
     * JavaBean Json 互转
     */
    public static void javaBeanToJson() {
        System.out.println("--------------------JavaBean转换为Json----------------------");
        UserInfo userInfo = new UserInfo();
        userInfo.setName("小明");
        userInfo.setAge(18);
        String json = JSON.toJSONString(userInfo);
        System.out.println(json);
        System.out.println("--------------------Json转换为JavaBean----------------------");
        UserInfo userInfo1 = JSON.parseObject(json, UserInfo.class);
        System.out.println(userInfo1.getName() + "---" + userInfo1.getAge());
    }

    /**
     * List<JavaBean> Json互转
     */
    public static void listToJson() {
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(new UserInfo("小红", 20));
        list.add(new UserInfo("小强", 22));
        String json = JSON.toJSONString(list);
        System.out.println("--------------------List<JavaBean>转换为Json----------------------");
        System.out.println(json);
        List<UserInfo> list1 = JSON.parseArray(json, UserInfo.class);
        System.out.println("--------------------Json转换为List<JavaBean>----------------------");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    /**
     * Map Json互转
     */
    public static void mapToJson() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        String json = JSON.toJSONString(map);
        System.out.println("--------------------Map转换为Json----------------------");
        System.out.println(json);
        Map map1 = JSON.parseObject(json);
        System.out.println("--------------------Json转换为Map----------------------");
        System.out.println(map1);
        for (Object o : map1.entrySet()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) o;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
