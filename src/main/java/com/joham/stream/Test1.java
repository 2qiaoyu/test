package com.joham.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by joham on 2017/7/16.
 */
public class Test1 {

    public static void main(String[] args) {
        Student student = new Student(15, "小明");
        Student student1 = new Student(12, "小强");
        Student student2 = new Student(14, "小红");
        List<Student> list = new ArrayList<Student>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        //第一种写法
        list.stream().map(student3 -> {
            student3.setName("测试");
            return student3;
        }).collect(Collectors.toList());
        list.stream().forEach(s -> System.out.println(s.getName()));

        //第二种写法
        list.stream().map(student3 -> set(student3)).collect(Collectors.toList());
        list.stream().forEach(s -> System.out.println(s.getName()));
    }

    public static Student set(Student student) {
        student.setName("测试");
        return student;
    }
}
