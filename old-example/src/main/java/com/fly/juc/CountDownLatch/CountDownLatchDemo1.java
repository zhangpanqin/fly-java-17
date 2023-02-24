package com.fly.juc.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName());

            }).start();
        }
        countDownLatch.await();
        System.out.println("已经执行完成");
    }
}
