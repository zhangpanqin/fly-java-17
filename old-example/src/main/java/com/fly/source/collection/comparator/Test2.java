package com.fly.source.collection.comparator;

import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2020-08-14-14:20
 */
public class Test2 {
    @Test
    public void run33() {
        System.out.println(1024);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }
}
