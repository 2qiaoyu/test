package com.joham.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by joham on 16/3/31.
 */
public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Student student = new Student(10,"小明");
        Student student1 = new Student(12,"小强");
        Student student2 = new Student(14,"小红");
        List<Student> list = new ArrayList<Student>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        //循环输出list
        list.forEach(s -> System.out.println(s.getName()));
        List<Student> list1 = new ArrayList<Student>();
        //条件查询id大于11的名字
        list.stream().filter(s -> s.getId()>11).forEach(s -> System.out.println(s.getName()));
        //将id大于11的重新列为一个集合
        list1 = list.stream().filter(s -> s.getId()>11).collect(Collectors.toList());
        //将名称提取出来在成为一个集合
        List<String> names = list.stream().map(Student::getName).collect(Collectors.toList());
        //将id和名称提取出来成为一个map
        Map<Integer, String> map = list.parallelStream().collect(Collectors.toMap(Student::getId,Student::getName));
        System.out.println(map);
    }
}
