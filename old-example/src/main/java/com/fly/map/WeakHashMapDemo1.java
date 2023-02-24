package com.fly.map;

import java.util.WeakHashMap;

public class WeakHashMapDemo1 {
    public static void main(String[] args) throws InterruptedException {
        final WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put(new String("1"), "2");
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap);
    }
}
