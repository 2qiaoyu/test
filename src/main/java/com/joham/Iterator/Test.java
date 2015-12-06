package com.joham.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by joham on 2015/9/22.
 */
public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        test1(list);
        test2(list);
    }

    private static void test1(List list){
        for(Iterator iterator = list.iterator();iterator.hasNext();){
            String str = (String)iterator.next();
            System.out.println(str);
        }
    }

    private static void test2(List list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

