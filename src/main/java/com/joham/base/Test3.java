package com.joham.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Java中的引用传递和值传递
 * （1）基本数据类型传值，对形参的修改不会影响实参；
 * （2）引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象；
 * （3）String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
 *
 * @author joham
 */
public class Test3 {

    public static void main(String[] args) {
        int a = 10;
        Integer b = 10;
        String c = "test";
        changeString(c);
        System.out.println(c);
        change(a);
        change2(b);
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        Student student = new Student(10);
        changeStudent(student);
        System.out.println(student.getAge());
        Student student1 = new Student(20);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        changeList(studentList);
        System.out.println(studentList.get(0).getAge());
    }

    private static void change(int number) {
        number = 20;
        System.out.println("number:" + number);
    }

    private static void change2(Integer number) {
        number = 20;
        System.out.println("number:" + number);
    }

    private static void changeStudent(Student student) {
        student.setAge(20);
    }

    private static void changeString(String c) {
        c = "notest";
    }

    private static void changeList(List<Student> studentList) {
        studentList.add(0, new Student(25));
    }
}
