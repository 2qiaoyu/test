package com.joham.concurrentcollections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 并发集合ConcurrentLinkedDeque
 *
 * @author joham
 */
public class AddTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10000; i++) {
            list.add(name + ";:Element:" + i);
        }
    }
}
