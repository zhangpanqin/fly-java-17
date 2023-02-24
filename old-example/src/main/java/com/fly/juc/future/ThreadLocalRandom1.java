package com.fly.juc.future;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张攀钦
 * @date 2020-10-06-12:13
 */
public class ThreadLocalRandom1 {
    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(12, 100, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            THREAD_POOL_EXECUTOR.execute(() -> {
                System.out.println(ThreadLocalRandom.current().nextInt(10));
            });
        }

    }
}
