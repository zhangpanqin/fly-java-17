package com.fly.source;

/**
 * @author 张攀钦
 * @date 2020-06-16-11:00
 * 验证线程别打断
 */
public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread th = new Thread(() -> {
            synchronized (obj) {
                System.out.println("执行了");
                try {
                    obj.wait();
                    System.out.println("唤醒了");
                } catch (InterruptedException e) {
                    System.out.println("抛出异常了");
                }
            }
        });
        th.start();
        Thread.sleep(1000);
        synchronized (obj) {
            obj.notifyAll();
        }
        th.join();
    }
}
