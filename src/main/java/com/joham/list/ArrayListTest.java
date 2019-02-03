package com.joham.list;

import java.util.ArrayList;
import java.util.List;

/**
 * subList造成异常
 *
 * @author joham
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List masterList = new ArrayList();
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
}
