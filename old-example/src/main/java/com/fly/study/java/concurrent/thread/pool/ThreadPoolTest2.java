package com.fly.study.java.concurrent.thread.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张攀钦
 * @date 2020-02-13-14:53
 * @description
 */
public class ThreadPoolTest2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>());
        CompletableFuture<Integer> future = new CompletableFuture<>();
        for (int i = 0; i < 10; i++) {
            Integer a =i;
            future.thenApplyAsync((in2)->{
                System.out.println(in2);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return in2+1;
            });
        }
        System.out.println(future.join());
    }
}
