package com.joham.runnable;

/**
 * 实现Runnable接口的多线程例子
 * 实现Runnable接口的类
 */
public class DoSomething implements Runnable {
    private String name;

    public DoSomething(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 100000000; k++) ;
            System.out.println(name + ": " + i);
        }
    }
}