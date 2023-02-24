package com.fly.juc.future;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张攀钦
 * @date 2020-10-06-02:21
 */
public class Future1 {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(12, 100, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(LocalDateTime.now());
        FutureTask<String> ft = new FutureTask<String>(() -> {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().isInterrupted());
            return "123";
        });

        THREAD_POOL_EXECUTOR.submit(ft);
        final String s = ft.get();
        System.out.println(LocalDateTime.now());
        System.out.println(s);
    }
}
