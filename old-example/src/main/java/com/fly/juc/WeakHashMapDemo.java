package com.fly.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.WeakHashMap;

/**
 * @author 张攀钦
 * @date 2020-06-25-09:50
 */
public class WeakHashMapDemo {
    @Data
    @AllArgsConstructor
    static class Demo {
        int a;
    }

    public static void main(String[] args) {
        WeakHashMap<Demo, String> objectObjectWeakHashMap = new WeakHashMap<>();
        for (int i = 0; i < 5; i++) {
            Demo demo = new Demo(i);
            objectObjectWeakHashMap.put(demo, String.valueOf(i));
            demo = null;
            System.gc();
        }
    }
}
