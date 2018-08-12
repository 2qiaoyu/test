package com.joham.net;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 检测主机是否在线
 *
 * @author joham
 */
public class GreenPing {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        //创建线程池
        ExecutorService pool = new ThreadPoolExecutor(10, 200, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("正在检测,请等待:");
        long time = System.currentTimeMillis();
        final AtomicLong count = new AtomicLong(0);
        for (int i = 1; i < 250; i++) {
            String ip = "120.27.248." + i;
            pool.execute(() -> {
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    //1000 ms
                    if (address.isReachable(1000)) {
                        count.incrementAndGet();
                        System.out.println("IP地址: " + ip + "  主机名: " + address.getHostName());
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        //关闭线程池
        pool.shutdown();

        //获取总数量和总耗时
        while (!pool.isTerminated()) {

        }
        System.out.println("共发现主机:" + count.get());
        System.out.println(System.currentTimeMillis() - time);
    }
}
