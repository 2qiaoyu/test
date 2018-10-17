package com.joham.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * java8 stream用法
 *
 * @author joham
 */
public class StreamTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test() {
        Student student = new Student(15, "小明");
        Student student1 = new Student(12, "小强");
        Student student2 = new Student(14, "小红");
        Student student3 = new Student(14, "小张");
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        //条件查询id大于11的名字
        System.out.println("id大于11的名字");
        System.out.println(list.stream().filter(s -> s.getId() > 11).collect(Collectors.toList()));

        System.out.println("取集合的前两个,忽略掉第一个");
        //取集合的前两个,忽略掉第一个
        list.stream().limit(2).skip(1).forEach(s -> System.out.println(s.getName()));

        //根据id排序
        System.out.println("根据id排序");
        list.stream().sorted(Comparator.comparing(Student::getId)).forEach(s -> System.out.println(s.getName()));

        //找出id最小的
        System.out.println("找出id最小的");
        System.out.println(list.stream().min(Comparator.comparing(Student::getId)).get().getName());

        //找出id最大的
        System.out.println("找出id最大的");
        System.out.println(list.stream().max(Comparator.comparing(Student::getId)).get().getName());

        //将姓名拼接字符串
        System.out.println("将姓名拼接字符串");
        System.out.println(list.stream().map(Student::getName).collect(joining(";")));

        //将id大于13的重新列为一个集合，并去重
        System.out.println("将id大于13的重新列为一个集合，并去重");
        list.stream().filter(s -> s.getId() > 13).distinct().collect(Collectors.toList()).forEach(s -> System.out.println(s.getName()));

        //将名称提取出来在成为一个集合
        System.out.println("将名称提取出来在成为一个集合");
        list.stream().map(Student::getName).collect(Collectors.toList()).forEach(System.out::println);

        //将id和名称提取出来id去重后成为一个map
        System.out.println("将id和名称提取出来id去重后成为一个map");
        list.remove(3);
        list.parallelStream().collect(Collectors.toMap(Student::getId, Student::getName));

        //flatMap 把 input Stream 中的层级结构扁平化
        System.out.println("flatMap");
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap(Collection::stream);
        outputStream.forEach(s -> System.out.println(s.longValue()));

        //利用reduce取得最小值
        System.out.println("利用reduce取得最小值");
        System.out.println(Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min));

        //利用reduce求和
        System.out.println("利用reduce求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));

        //allMatch：Stream 中全部元素符合传入的 predicate，返回 true
        //anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
        //noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true
        System.out.println("allMatch");
        System.out.println(list.stream().allMatch(s -> s.getId() > 10));
        System.out.println("anyMatch");
        System.out.println(list.stream().anyMatch(s -> s.getId() > 13));
        System.out.println("noneMatch");
        System.out.println(list.stream().noneMatch(s -> s.getId() > 20));
    }

    /**
     * 构建流的几种方法
     */
    private static void test1() {
        // 1. Individual values
        Stream stream1 = Stream.of("a", "b", "c");
        System.out.println(stream1);
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        Stream stream2 = Stream.of(strArray);
        System.out.println(stream2);
        Stream stream3 = Arrays.stream(strArray);
        System.out.println(stream3);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        Stream stream4 = list.stream();
        System.out.println(stream4);
    }
}
