package com.fly.study.java.concurrent.util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author 张攀钦
 * @date 2019-12-15-11:19
 * @description
 */
public class CountDownLatchTest {

    public static void doSomething(CountDownLatch countDownLatch) throws InterruptedException {
        final int i = new Random().nextInt(500);
        Thread.sleep(i);
        System.out.println("完成了任务");
        countDownLatch.countDown();

    }

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                try {
                    doSomething(countDownLatch);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
//      阻塞，在这里等待 count 为 0
        countDownLatch.await();
        System.out.println("都完成了");
        System.out.println(2222);
    }
}
