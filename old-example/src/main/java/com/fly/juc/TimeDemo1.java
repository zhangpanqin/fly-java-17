package com.fly.juc;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张攀钦
 * @date 2020-09-01-23:18
 */
public class TimeDemo1 {
    public static void main(String[] args) {
        run2();
    }

    private static void test22() {
        final Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
            }
        };
        timer.schedule(timerTask, 100, 1000);
    }

    public static void run2() {
        final ScheduledExecutorService scheduledExecutorService1 = new ScheduledThreadPoolExecutor(10);
        final ScheduledFuture<?> schedule = scheduledExecutorService1.scheduleAtFixedRate(() -> {
            System.out.println(1111);
        }, 10, 1000, TimeUnit.MILLISECONDS);
    }
}
