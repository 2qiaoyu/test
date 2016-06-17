package com.joham.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestToJson {
    public static void main(String[] args) {
        beanToJson();
        beanToJson1();
        beanToJson2();
        ArrayToJson();
        listToJson();
        mapToJson();
    }

    public static void beanToJson() {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setAge(24);
        employee.setDepartment("财务");
        JSONObject jsonObject = JSONObject.fromObject(employee);
        System.out.println("-----------------------------------------beanToJson() 开始------------------------------------------------");
        System.out.println(jsonObject.toString());
        System.out.println("-----------------------------------------beanToJson() 结束------------------------------------------------");
    }

    public static void beanToJson1() {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setAge(24);
        employee.setDepartment("财务");
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"age"});
        JSONObject jsonObject = JSONObject.fromObject(employee, jsonConfig);
        System.out.println("-----------------------------------------beanToJson1()带过滤器 开始------------------------------------------------");
        System.out.println(jsonObject.toString());
        System.out.println("-----------------------------------------beanToJson1()带过滤器 结束------------------------------------------------");
    }

    public static void beanToJson2() {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setAge(24);
        employee.setDepartment("财务");
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            @Override
            public boolean apply(Object source, String name, Object value) {
                return source instanceof Employee && name.equals("age");
            }
        });
        JSONObject jsonObject = JSONObject.fromObject(employee, jsonConfig);
        System.out.println("-----------------------------------------beanToJson2()带过滤器 开始------------------------------------------------");
        System.out.println(jsonObject.toString());
        System.out.println("-----------------------------------------beanToJson2()带过滤器 结束------------------------------------------------");
    }

    public static void ArrayToJson() {
        Employee employee1 = new Employee();
        employee1.setName("小明");
        employee1.setAge(24);
        employee1.setDepartment("财务");
        Employee employee2 = new Employee();
        employee2.setName("小王");
        employee2.setAge(23);
        employee2.setDepartment("研发");
        Employee[] employees = new Employee[]{employee1, employee2};
        JSONArray jsonArray = JSONArray.fromObject(employees);
        System.out.println("-----------------------------------------arrayToJson() 开始------------------------------------------------");
        System.out.println(jsonArray.toString());
        System.out.println("-----------------------------------------arrayToJson() 结束------------------------------------------------");
    }

    public static void listToJson() {
        List<String> list = new ArrayList<String>();
        list.add("qwer");
        list.add("asdf");
        JSONArray jsonArray = JSONArray.fromObject(list);
        System.out.println("-----------------------------------------listToJson() 开始------------------------------------------------");
        System.out.println(jsonArray.toString());
        System.out.println("-----------------------------------------listToJson() 结束------------------------------------------------");
    }

    public static void mapToJson() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("name", "json");
        map.put("bool", Boolean.TRUE);
        map.put("int", new Integer(1));
        map.put("arr", new String[]{"q", "w"});
        map.put("fun", "function(i){ return this.arr[i]; }");
        JSONArray jsonArray = JSONArray.fromObject(map);
        System.out.println("JSONArray转换");
        System.out.println(jsonArray.toString());
        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println("JSONObject转换");
        System.out.println(jsonObject.toString());
    }
}
