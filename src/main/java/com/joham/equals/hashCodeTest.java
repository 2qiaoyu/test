package com.joham.equals;

import java.util.HashMap;
import java.util.Map;

/**
 * @author joham
 */
public class hashCodeTest {
    public static void main(String[] args) {
        Worker worker1 = new Worker("wang");
        Worker worker2 = new Worker("wang");

        System.out.println("worker1.equals(worker2)的结果为" + worker1.equals(worker2));
        System.out.println("worker1.hashCode()=" + worker1.hashCode() + " | worker2.hashCode()=" + worker2.hashCode());

        Map<Worker, Integer> map1 = new HashMap<Worker, Integer>();
        map1.put(worker1, new Integer(10));
        System.out.println(map1.get(worker2));
    }
}

class Worker {
    private String name;

    Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 重写equals方法，让其名字相等则判断对象相等
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return (this.name.equals(((Worker) obj).name));
    }

}
