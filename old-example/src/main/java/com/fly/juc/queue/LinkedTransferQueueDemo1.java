package com.fly.juc.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class LinkedTransferQueueDemo1 {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<Integer> LTQ = new LinkedTransferQueue<>();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(LTQ.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        LTQ.tryTransfer(122, 11, TimeUnit.SECONDS);
        System.out.println(1);
    }
}
