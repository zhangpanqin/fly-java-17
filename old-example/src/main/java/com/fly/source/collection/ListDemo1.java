package com.fly.source.collection;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2020-08-13-11:12
 */
public class ListDemo1 {

    @Test
    public void run1() {
        final ArrayList<Object> objects = new ArrayList<>(5);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        System.out.println(objects);
        objects.set(1, 2);
        System.out.println(objects);
    }

    @Test
    public void run2() {
        System.out.println(6 >> 1);
    }

    @Test
    public void run3() {
        final ArrayList<Integer> objects = new ArrayList<>(5);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        objects.retainAll(Arrays.asList(2, 4));
        System.out.println(objects);
    }

    @Test
    public void run4() {
        final ArrayList<Integer> objects = new ArrayList<>(5);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);

        final Iterator<Integer> iterator = objects.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(objects);
    }

    @Test
    public void run5() {
        final ArrayList<Integer> objects = new ArrayList<>(5);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        final Stream<Integer> integerStream = objects.parallelStream();
    }

    @Test
    public void run6() {
        final ArrayList<Integer> objects = new ArrayList<>(10);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        Collections.shuffle(objects);
        System.out.println(objects);
    }
}
