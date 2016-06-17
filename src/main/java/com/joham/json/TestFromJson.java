package com.joham.json;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestFromJson {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setAge(24);
        employee.setDepartment("财务");
        JSONObject jsonObject = JSONObject.fromObject(employee);
        System.out.println("json:"+jsonObject);
        Map<String,Object> map = new HashMap<String,Object>();
        map=getMapFromJson(jsonObject.toString());
        System.out.println("map:");
        System.out.println("age:"+map.get("age"));
        System.out.println("department:"+map.get("department"));
        System.out.println("name:"+map.get("name"));
    }

    public static Map<String, Object> getMapFromJson(String jsonString) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
            String key = (String) iter.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }
}
