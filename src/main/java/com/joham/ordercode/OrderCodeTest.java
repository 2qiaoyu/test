package com.joham.ordercode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderCodeTest {

    public static void main(String[] agrs) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            String a = CodeGenUtil.genOrderCode();
            System.out.println(a);
            stringList.add(a);
        }
        Set<String> set = new HashSet<>();
        Set<String> exist = new HashSet<>();

        for (String s : stringList) {
            if (set.contains(s)) {
                exist.add(s);
            } else {
                set.add(s);
            }
        }
        System.out.println("重复的值：" + String.join(", ", exist));
    }
}
