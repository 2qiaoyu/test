package com.ningpai.xml;

/**
 * Created by joham on 2015/8/22.
 */
public class TestXml {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setAge(24);
        employee.setDepartment("财务");
        JaxbUtil jaxbUtil = new JaxbUtil();
        String xml = jaxbUtil.convertToXml(employee);
        System.out.println(xml);
        System.out.println("----------------------------------------");
        Employee employee1 = jaxbUtil.converyToJavaBean(xml,Employee.class);
        System.out.println(employee1.getName());
        System.out.println(employee1.getAge());
        System.out.println(employee1.getDepartment());
    }
}
