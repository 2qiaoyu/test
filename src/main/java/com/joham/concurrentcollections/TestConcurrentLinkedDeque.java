package com.joham.concurrentcollections;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 并发集合ConcurrentLinkedDeque测试类
 * 使用非阻塞线程安全的列表
 * http://ifeve.com/concurrent-collections-2/
 *
 * @author qiaoyu
 */
public class TestConcurrentLinkedDeque {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        Thread threads[] = new Thread[100];

        //创建100个AddTask对象，对于它们中的每一个用一个线程来运行。用之前创建的数组来存储每个线程，并启动这些线程。
        for (int i = 0; i < threads.length; i++) {
            AddTask task = new AddTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("AddTask threads have been launched %d\n", threads.length);

        //使用join()方法，等待这些线程的完成。
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Size of the List:%d\n", list.size());

        //创建100个PollTask对象，对于它们中的每一个用一个线程来运行。用之前创建的数组来存储每个线程，并启动这些线程。
        for (int i = 0; i < threads.length; i++) {
            PollTask task = new PollTask(list);
            threads[i] = new Thread(task);
            threads[i].start();
        }
        System.out.printf("PollTask threads have been launched %d\n", threads.length);

        //使用join()方法，等待这些线程的完成。
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Size of the List:%d", list.size());
    }
}
