package com.joham.base;

/**
 * Created by joham on 2016/1/29.
 * 获得类名
 */
public class TestName {
    public static void main(String[] args) {
        System.out.println(TestName.class.getSimpleName());
        System.out.println(TestName.class);
        System.out.println(TestName.class.getClass());
        System.out.println(TestName.class.getName());
    }
}
