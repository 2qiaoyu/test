package com.joham.base;

/**
 * ==和equals
 */
public class Test4 {

    public static void main(String[] args) {
        Integer a = new Integer(15);
        Integer b = new Integer(15);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        String c = new String("123");
        String d = new String("123");
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
