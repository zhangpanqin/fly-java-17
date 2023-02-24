package com.fly.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 张攀钦
 * @date 2020-10-07-04:12
 */
public class ReentrantLockDemo {

    static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            REENTRANT_LOCK.lock();
            try {
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                REENTRANT_LOCK.unlock();
            }
        }, "local-1").start();

        TimeUnit.SECONDS.sleep(1);
        final Thread thread = new Thread(() -> {
            System.out.println("lock-2 执行了");
            try {
                //
                REENTRANT_LOCK.lockInterruptibly();
                REENTRANT_LOCK.lock();
                try {
                    System.out.println("lock-2 获取锁之后执行了");
                } finally {
                    REENTRANT_LOCK.unlock();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "lock-2");
        thread.start();

//        TimeUnit.SECONDS.sleep(2);
//        new Thread(() -> {
//            thread.isInterrupted();
//            System.out.println("lock-2 被中断了");
//        }).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> {
            try {
                REENTRANT_LOCK.tryLock(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
            System.out.println("lock-2 的打断标记为:" + thread.isInterrupted());
        }).start();
    }
}
