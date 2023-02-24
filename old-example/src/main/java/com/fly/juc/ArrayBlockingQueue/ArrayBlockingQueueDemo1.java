package com.fly.juc.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> objects = new ArrayBlockingQueue<>(3);
        objects.add("1");
        objects.add("1");
        objects.add("1");
        objects.add("4");
        System.out.println(objects);
    }
}
