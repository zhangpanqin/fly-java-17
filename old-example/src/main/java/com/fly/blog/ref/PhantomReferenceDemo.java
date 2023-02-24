package com.fly.blog.ref;

import com.google.common.collect.Lists;
import lombok.Data;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/**
 * @author 张攀钦
 * @date 2020-06-25-21:01
 */
public class PhantomReferenceDemo {
    // 1m
    private static int _1M = 1024 * 1024 * 1;

    private static ReferenceQueue referenceQueue = new ReferenceQueue();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> objects = Lists.newArrayListWithCapacity(50);

        int count = 1;

        new Thread(() -> {
            while (true) {
                try {
                    Reference remove = referenceQueue.remove();
                    if (objects.remove(remove)) {
                        System.out.println("移除元素");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true) {
            Thread.sleep(500);
            // 获取 jvm 空闲的内存为多少 m
            long meme_free = Runtime.getRuntime().freeMemory() / _1M;
            if ((meme_free - 10) > 40) {
                Demo demo = new Demo(count);
                PhantomReference<Demo> demoWeakReference = new PhantomReference<>(demo, referenceQueue);
                objects.add(demoWeakReference);
                count++;
                demo = null;
            }
            System.out.println("jvm 空闲内存" + meme_free + " m");
            System.out.println(objects.size());
        }
    }

    @Data
    static class Demo {
        private byte[] a = new byte[_1M * 10];
        private String str;

        public Demo(int i) {
            this.str = String.valueOf(i);
        }
    }
}
