package com.fly.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 张攀钦
 * @date 2020-10-07-04:59
 * 先阻塞线程
 * 线程没有被阻塞掉
 */
public class LockSupportDemo {
    static Object LOCK = new Object();

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            try {
                System.out.println("先阻塞线程");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park(LOCK);
            System.out.println("线程没有被阻塞掉");
        });
        thread.start();
        LockSupport.unpark(thread);
    }
}
