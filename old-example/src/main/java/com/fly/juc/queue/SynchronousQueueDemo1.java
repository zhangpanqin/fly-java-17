package com.fly.juc.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo1 {
    public static void main(String[] args) {
        final SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue();

        new Thread(() -> {
            Integer temp = 1;
            while (true) {
                try {
                    Thread.sleep(2000);
                    if (synchronousQueue.offer(temp, 3, TimeUnit.SECONDS)) {
                        System.out.println("插入成功");
                        temp++;
                    } else {
                        System.out.println("没有插入");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
//        new Thread(() -> {
//            try {
//                System.out.println(synchronousQueue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
}
