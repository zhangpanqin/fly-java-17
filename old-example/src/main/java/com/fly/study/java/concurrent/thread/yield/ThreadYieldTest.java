package com.fly.study.java.concurrent.thread.yield;

/**
 * @author 张攀钦
 * @date 2020-02-27-22:22
 * @description
 */
public class ThreadYieldTest implements Runnable {


    public ThreadYieldTest() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + "yield cpu ...");

//                测试 Thread.yield 的效果
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {

        new ThreadYieldTest();
        new ThreadYieldTest();
        new ThreadYieldTest();
    }
}
