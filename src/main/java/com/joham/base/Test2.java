package com.joham.base;

import org.elasticsearch.common.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class Test2 {
    public static void main(String[] args) {
        /**
         * list元素用逗号分隔开来
         */
        List<String> list = new ArrayList<>();
        list.add("1234");
        list.add("qwer");
        list.add("zxcv");
        System.out.println(StringUtils.join(list, ","));
        System.out.println(String.join(",", list));
    }
}
