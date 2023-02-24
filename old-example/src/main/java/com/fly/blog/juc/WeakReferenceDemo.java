package com.fly.blog.juc;

import lombok.Data;
import java.lang.ref.WeakReference;

/**
 * @author 张攀钦
 * @date 2020-06-22-22:07
 */
public class WeakReferenceDemo {

    @Data
    static class Demo {
        private int a = 1;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        WeakReference weakReference = new WeakReference<>(demo);
        System.out.println(weakReference.get());
        System.gc();
        System.out.println("gc之后-" + weakReference.get());
        demo = null;
        System.gc();
        System.out.println("demo=null, gc之后-" + weakReference.get());
    }
}
