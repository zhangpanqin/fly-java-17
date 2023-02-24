package com.fly.study.java.concurrent.thread.happenbofore;

import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-03-16:13
 * @description
 */
public class HappenBefore1 {

    @Test
    public void run11() throws InterruptedException {

        Demo demo = new Demo();
        new Thread(() -> {
            for (int i = 0; i < 1000000000; i++) {
                demo.count++;
                if (i == 5000000) {
                    new Thread(() -> {
                        for (int j = 0; j < 1000000000; j++) {

                            demo.count++;
                        }
                    }).start();
                }
            }
        }).start();
        Thread.sleep(30000);
        System.out.println(demo.count);
    }

}

class Demo {
    volatile int count = 0;
}
