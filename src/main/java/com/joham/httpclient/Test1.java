package com.joham.httpclient;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 多线程请求
 *
 * @author joham
 */
public class Test1 {

    public static final String URL = "http://180.167.17.28:8000/item/";

    public static void main(String[] args) {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(5, 100, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("正在检测,请等待:");
        long time = System.currentTimeMillis();
        final AtomicLong count = new AtomicLong(0);
        for (int i = 12000; i < 1184676; i++) {
            String itemUrl = URL + i + ".html";
            pool.execute(() -> {
                System.out.println("请求线程：" + Thread.currentThread());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                HttpClientUtil.get(itemUrl, null);
                count.incrementAndGet();
                System.out.println("url" + itemUrl);
            });
            System.out.println("12312" + pool.toString());
        }

        //关闭线程池
        pool.shutdown();
        System.out.println("qweq" + pool.isTerminated());
        //获取总数量和总耗时
        while (!pool.isTerminated()) {

        }
        count.incrementAndGet();
        System.out.println("数量:" + count.get());
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }
}
