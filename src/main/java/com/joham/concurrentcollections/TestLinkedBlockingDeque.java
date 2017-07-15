package com.joham.concurrentcollections;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 并发集合LinkedBlockingDeque
 * 使用阻塞线程安全的列表
 * http://ifeve.com/concurrent-collections-3/
 *
 * @author qiaoyu
 */
public class TestLinkedBlockingDeque {
    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque(3);
        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                String request = list.take();
                System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), list.size());
            }
            TimeUnit.SECONDS.sleep(300);
        }
        System.out.printf("Main: End of the program.\n");
    }
}
