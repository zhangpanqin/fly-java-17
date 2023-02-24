package com.fly.study.java.object;

/**
 * @author 张攀钦
 * @date 2019-12-03-23:09
 * @description
 */
public class waitnotify {

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                System.out.println("1-加锁前");
                try {
                    lock.wait();
                    System.out.println("1-解锁后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("2-加锁前");
                try {
                    lock.wait();
                    System.out.println("2-解锁后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("3-加锁前");
                try {
                    lock.wait();
                    System.out.println("3-解锁后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println("4-加锁前");
                try {
                    Thread.sleep(5000);
                    lock.notify();
                    lock.wait(5);
                    System.out.println("4-解锁后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
