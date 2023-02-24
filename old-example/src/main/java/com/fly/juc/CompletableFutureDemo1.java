package com.fly.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Administrator
 */
public class CompletableFutureDemo1 {
    public static void main(String[] args) throws Exception {
        test2();
    }

    private static void test2() throws InterruptedException, ExecutionException {
        final CompletableFuture<Void> voidCompletableFuture = CompletableFuture.completedFuture(1).thenAcceptAsync(data -> {
            System.out.println(Thread.currentThread().getName() + "线程中执行，接收到的参数：" + data);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        voidCompletableFuture.get();
        System.out.println("主线程执行");

    }

    private static void test1() {
        CompletableFuture.completedFuture(1).thenAccept(data -> {
            System.out.println();
            System.out.println(Thread.currentThread().getName() + "线程中执行，接收到的参数：" + data);
        }).completeExceptionally(new RuntimeException("接受异常"));
        System.out.println("主线程执行");
    }
}
