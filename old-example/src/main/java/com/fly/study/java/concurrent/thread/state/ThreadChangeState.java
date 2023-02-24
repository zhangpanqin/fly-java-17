package com.fly.study.java.concurrent.thread.state;

import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2019-12-07-23:07
 * @description 线程状态切换
 */
public class ThreadChangeState {

    private static Object lock = new Object();


    public static void main(String[] args) {

        final Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(4444);
                    lock.wait(3000);
                    System.out.println(3333333);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                }
            }
        });

        final DemoCount demoCount = new DemoCount();
        new Thread(()->{
           while (true){
               final Thread.State state1 = thread.getState();
               if (!Objects.equals(demoCount.state, state1)) {
                   demoCount.state=state1;
                   System.out.println("Thread" + state1);
               }
           }
       }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println(22);
                final long l = System.currentTimeMillis();
                while (true){
                    if ((System.currentTimeMillis()-3)>0){
                        return;
                    }
                }
            }
        }).start();
        thread.start();
    }

}
class DemoCount{
     volatile int count;
     volatile Thread.State state;
}