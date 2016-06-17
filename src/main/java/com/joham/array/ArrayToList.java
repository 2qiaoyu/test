package com.joham.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {

    public static void main(String[] args) {
        String[] array = new String[]{"str1", "str2"};
        List<String> list = new ArrayList<>();
        list = arrayToList(array);
        System.out.println(list);
        System.out.println(listToArray(list));
    }

    /**
     * 数组转List
     */
    public static List<String> arrayToList(String array[]) {
        return Arrays.asList(array);
    }

    /**
     * List转数组
     */
    public static String[] listToArray(List<String> list) {
        int size = list.size();
        return list.toArray(new String[size]);
    }
}
