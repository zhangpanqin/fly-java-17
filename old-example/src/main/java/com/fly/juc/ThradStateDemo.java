package com.fly.juc;

/**
 * @author 张攀钦
 * @date 2020-08-11-22:05
 */
public class ThradStateDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        final Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(0);
                    System.out.println(11111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
