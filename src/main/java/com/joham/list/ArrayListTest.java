package com.joham.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList的一些异常
 *
 * @author joham
 */
public class ArrayListTest {

    public static void main(String[] args) {
//        testSubList();
//        testArray();
        ListToArray();
    }

    /**
     * 在subList场景中，高度注意对原列表的修改，会导致子列表的遍历、增加、删除均产生ConcurrentModificationException异常。
     */
    private static void testSubList() {
        List<String> masterList = new ArrayList<>();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");

        List branchList = masterList.subList(1, 2);
        //抛出异常
        masterList.add("four");
        for (Object t : branchList) {
            System.out.println(t);
        }
    }

    /**
     * 使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，它的add/remove/clear方法会抛出UnsupportedOperationException异常。
     */
    private static void testArray() {
        List<String> list = Arrays.asList("one", "two", "three");
        list.add("four");
        for (Object t : list) {
            System.out.println(t);
        }
    }

    private static void ListToArray() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        //泛型丢失，无法使用String[]接收无参方法返回的结果
        Object[] array1 = list.toArray();

        //array2数组长度小于元素个数
        String[] array2 = new String[2];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2));

        //array3数组长度等于元素个数
        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));
    }
}
