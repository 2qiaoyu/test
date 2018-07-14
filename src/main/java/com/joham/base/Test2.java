package com.joham.base;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * join用法
 * StringUtils要引入jar包common-lang3, String.join()是JDK8新增方法。
 *
 * @author joham
 */
public class Test2 {
    public static void main(String[] args) {
        //list元素用逗号分隔开来
        List<String> list = new ArrayList<>();
        list.add("1234");
        list.add("qwer");
        list.add("zxcv");
        System.out.println(StringUtils.join(list, ","));
        System.out.println(String.join(",", list));
    }
}
