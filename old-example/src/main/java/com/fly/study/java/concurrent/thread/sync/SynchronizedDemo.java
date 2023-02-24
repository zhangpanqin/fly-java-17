package com.fly.study.java.concurrent.thread.sync;



/**
 * @author 张攀钦
 * @date 2019-12-02-21:36
 * @description
 */
public class SynchronizedDemo {
    public  volatile int a = 0;

    public synchronized void log() {
        System.out.println(11);
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10; j++) {
                    synchronizedDemo.addA();
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(synchronizedDemo.a);
    }

    public  void addA(){
        this.a++;
    }
}
