package com.joham.xml;

public class TestXml {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setAge(24);
        employee.setDepartment("财务");
        JaxbUtil jaxbUtil = new JaxbUtil();
        String xml = JaxbUtil.convertToXml(employee);
        System.out.println(xml);
        System.out.println("----------------------------------------");
        Employee employee1 = JaxbUtil.converyToJavaBean(xml, Employee.class);
        System.out.println(employee1.getName());
        System.out.println(employee1.getAge());
        System.out.println(employee1.getDepartment());
    }
}
