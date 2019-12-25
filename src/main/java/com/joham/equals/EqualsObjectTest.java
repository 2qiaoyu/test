package com.joham.equals;

import java.util.HashSet;
import java.util.Set;

/**
 * @author joham
 */
public class EqualsObjectTest {

    public static void main(String[] args) {
        Set<EqualsObject> hashSet = new HashSet<>();
        EqualsObject a = new EqualsObject(1, "one");
        EqualsObject b = new EqualsObject(1, "one");
        EqualsObject c = new EqualsObject(1, "one");

        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);
        System.out.println(hashSet.size());
    }
}
