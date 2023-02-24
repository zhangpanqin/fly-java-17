package com.fly.study.java.collection;

import org.junit.jupiter.api.Test;
import java.util.BitSet;

/**
 * @author 张攀钦
 * @date 2019-12-03-15:08
 * @description
 */
public class BitSetDemo {
    @Test
    public void run1() {
        BitSet bitSet =new BitSet(10);
        bitSet.set(2);
        bitSet.set(5);
        for (int i = 0; i <10 ; i++) {
            System.out.println(bitSet.nextClearBit(i));
        }
    }


}
