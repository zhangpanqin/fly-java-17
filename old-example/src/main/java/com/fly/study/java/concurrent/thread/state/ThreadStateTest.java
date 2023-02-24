package com.fly.study.java.concurrent.thread.state;

/**
 * @author 张攀钦
 * @date 2019-10-10-14:52
 * @description 线程状态验证
 */
public class ThreadStateTest {

    private static final Object OBJECT = new Object();

    public static void main(String[] args) throws InterruptedException {
        final Thread thread2 = new Thread(()->{

            synchronized (OBJECT){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final Thread thread = new Thread(()->{
            synchronized (OBJECT){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    OBJECT.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();
        while (true){
            Thread.sleep(500);
            System.out.println("thread"+thread.getState());
            System.out.println("thread2"+thread2.getState());
        }
    }
}

