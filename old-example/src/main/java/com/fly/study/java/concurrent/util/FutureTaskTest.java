package com.fly.study.java.concurrent.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 张攀钦
 * @date 2019-12-15-18:33
 * @description
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final FutureTask futureTask = new FutureTask(() -> {
            Thread.sleep(1000);
            return "1234";
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        System.out.println("等待完成");

    }
}
