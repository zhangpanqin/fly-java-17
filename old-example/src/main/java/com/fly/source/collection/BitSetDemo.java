package com.fly.source.collection;

import java.util.Arrays;
import java.util.BitSet;

/**
 * @author 张攀钦
 * @date 2020-08-14-11:18
 */
public class BitSetDemo {
    public static void main(String[] args) {
            final BitSet bitSet = new BitSet(10);
            bitSet.set(0);
            bitSet.set(1);
            bitSet.set(5);
            bitSet.set(10);
            System.out.println(bitSet);
            System.out.println(Arrays.toString(bitSet.toByteArray()));
            System.out.println(bitSet.get(15));
    }
}
