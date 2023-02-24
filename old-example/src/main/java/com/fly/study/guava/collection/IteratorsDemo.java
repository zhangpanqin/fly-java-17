package com.fly.study.guava.collection;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 张攀钦
 * @date 2019-12-05-21:46
 * @description
 */
public class IteratorsDemo {
    @Test
    public void run1() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = integers.iterator();
        PeekingIterator<Integer> integerPeekingIterator = Iterators.peekingIterator(iterator);
        while (integerPeekingIterator.hasNext()) {
            Integer next = integerPeekingIterator.next();
            if (integerPeekingIterator.hasNext()&&integerPeekingIterator.peek() == 3) {
                integerPeekingIterator.next();
            }
            System.out.println(next);
        }
    }
}
