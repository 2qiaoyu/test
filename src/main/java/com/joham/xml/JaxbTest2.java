package com.joham.xml;

public class JaxbTest2 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(12);
        student.setName("test");
        Role role = new Role();
        role.setDesc("管理");
        role.setName("班长");
        student.setRole(role);
        String str = JaxbUtil.convertToXml(student);
        System.out.println(str);
        System.out.println("-----------------------------------------------");
        Student student1 = JaxbUtil.converyToJavaBean(str, Student.class);
        System.out.println(student1);
    }
}