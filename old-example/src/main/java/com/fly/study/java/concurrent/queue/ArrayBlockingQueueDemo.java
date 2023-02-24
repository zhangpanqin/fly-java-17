package com.fly.study.java.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author 张攀钦
 * @date 2020-02-17-08:38
 * @description
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(20);
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                strings.add("生产者产生消息："+i);
            }
        }).start();
        new Thread(()->{
            try {
                while (true) {
                    Thread.sleep(200);
//                    System.out.println("取值："+strings.take());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
