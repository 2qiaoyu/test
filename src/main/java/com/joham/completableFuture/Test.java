package com.joham.completableFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Test {

    public static void main(String[] args) {
        System.out.println("1");
        // 异步处理
        CompletableFuture<Void> completableFuture =
                CompletableFuture.runAsync(() -> doSomeThing());
        System.out.println("2");
        // 异步回调处理
        completableFuture.whenCompleteAsync((aVoid, throwable) -> {
            System.out.println("3");
            if (null != throwable) {
                log.error("异常:", throwable.fillInStackTrace());
            }
        });
        System.out.println("4");
    }

    static void doSomeThing() {
        System.out.println("doSomeThing");
        throw new RuntimeException();
    }
}
