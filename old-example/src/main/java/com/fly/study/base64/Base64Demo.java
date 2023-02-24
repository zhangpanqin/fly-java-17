package com.fly.study.base64;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 张攀钦
 * @date 2020-08-12-17:18
 */
public class Base64Demo {
    @Test
    public void run1() {
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        for (Object object : objects) {
            objects.add(2);
        }
    }

    @Test
    public void run2() {
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(1);
        final Iterator<Object> objectListIterator = objects.iterator();
        while (objectListIterator.hasNext()) {
            System.out.println(objectListIterator.next());
            objects.remove(1);
        }
    }
    @Test
    public void run3() {
        final ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(1);
        objects.add(4);
        objects.add(5);
        final Iterator<Object> objectListIterator = objects.listIterator();
        while (objectListIterator.hasNext()) {
            System.out.println(objectListIterator.next());
            objects.remove(2);
        }
    }
}
