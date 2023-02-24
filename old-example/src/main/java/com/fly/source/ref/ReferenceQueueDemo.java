package com.fly.source.ref;

import lombok.Data;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author 张攀钦
 * @date 2020-06-24-17:15
 */
public class ReferenceQueueDemo {
    private static final ReferenceQueue REFERENCE_QUEUE = new ReferenceQueue();

    static class WeakReference2<T> extends WeakReference<T>{
        public WeakReference2(T referent) {
            super(referent);
        }

        public WeakReference2(T referent, ReferenceQueue<? super T> q) {
            super(referent, q);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            Reference ref = null;
            while (true) {
                try {
                    if ((ref = REFERENCE_QUEUE.remove()) != null) {
                        System.out.println("ReferenceQueue 移除" + ref);
                        System.out.println(ref.get());
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


        for (int i = 0; i < 5; i++) {
            Demo demo = new Demo(i);
            WeakReference2 weakReference = new WeakReference2(demo, REFERENCE_QUEUE);
            System.out.println(weakReference);
            System.out.println("设置 demo 为 null");
            demo = null;
            weakReference = null;
            System.gc();
            Thread.sleep(1000);
            System.out.println("gc");
        }

        while (true) {
        }
    }

    @Data
    static class Demo {
        public String string = "初始值";

        public Demo() {
        }

        public Demo(int i) {
            this.string = String.valueOf(i);
        }
    }
}
