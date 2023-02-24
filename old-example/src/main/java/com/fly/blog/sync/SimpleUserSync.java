package com.fly.blog.sync;

import com.google.common.collect.Lists;
import java.util.ArrayList;

/**
 * @author 张攀钦
 * @date 2020-06-13-16:07
 */
public class SimpleUserSync {

    public static int a = 0;

    public static void main(String[] args) {
        // 开 10 个线程不停的访问方法
        final ArrayList<Thread> threads = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            final Thread thread = new Thread(() -> {
                try {
                    // 为了让线程不那么早结束
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i1 = 0; i1 < 1000; i1++) {
                    SimpleUserSync.addA_1();
                }
            });
            threads.add(thread);
            thread.start();
        }
        threads.stream().forEachOrdered(thread -> {
            try {
                // 让所有的线程阻塞,知道 thread 执行完毕
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(SimpleUserSync.a);
    }

    public synchronized static void addA_1() {
        a++;
    }

    private static final Object LOCK =new Object();

    public static void addA_2() {
        synchronized (LOCK){
        a++;
        }
    }
}
