package com.fly.study.performance;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 张攀钦
 * @date 2020-06-01-20:33
 */
public class GC {
    private static final Map MAP = new ConcurrentHashMap(10000);

    public static void main(String[] args) {
        int count = 1;
        while (true) {
            final byte[] bytes = new byte[1024 * 1024 * 1];
            if (count < 400) {
                MAP.put(ThreadLocalRandom.current().nextInt(), bytes);
                count++;
            }
        }


    }
}
