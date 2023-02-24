package com.fly.study.java.concurrent.thread.dead;

/**
 * @author 张攀钦
 * @date 2019-11-20-20:54
 * @description 线程死锁的演示
 */
public class DeadThreadDemo {
    public static void main(String[] args) {
                Object lock1=new Object();
                Object lock2=new Object();
                new Thread(()->{
                    synchronized (lock1){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2){
                            System.out.println(1);
                        }
                    }
                }).start();
                new Thread(()->{
                    synchronized (lock2){
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock1){
                            System.out.println(1);
                        }
                    }
                }).start();
    }
}
