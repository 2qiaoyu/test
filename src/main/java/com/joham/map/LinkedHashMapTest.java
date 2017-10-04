package com.joham.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {

        //无序
        System.out.println("====================================无序========================================");
        Map<String, String> map = new HashMap<>();
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        map.put("peach", "桃子");

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        //有序
        System.out.println("====================================有序========================================");
        Map<String, String> map1 = new LinkedHashMap<>(16, 0.75f, true);
        map1.put("apple", "苹果");
        map1.put("watermelon", "西瓜");
        map1.put("banana", "香蕉");
        map1.put("peach", "桃子");
        Iterator iter1 = map1.entrySet().iterator();
        while (iter1.hasNext()) {
            Map.Entry entry = (Map.Entry) iter1.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        //根据读取的数据排序
        System.out.println("====================================根据读取的数据排序========================================");
        Map<String, String> map2 = new LinkedHashMap<>(16, 0.75f, true);
        map2.put("apple", "苹果");
        map2.put("watermelon", "西瓜");
        map2.put("banana", "香蕉");
        map2.put("peach", "桃子");

        map2.get("banana");
        map2.get("apple");

        Iterator iter2 = map2.entrySet().iterator();
        while (iter2.hasNext()) {
            Map.Entry entry = (Map.Entry) iter2.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

}
