package com.fly.study.java.collection;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * @author 张攀钦
 * @date 2019-12-03-14:35
 * @description
 */
public class ArrayListDemo {

    @Test
    public void run11() {
        System.out.println(1);
        ArrayList<Object> objects = new ArrayList<>(10);
        objects.add(9,"1");
        System.out.println(objects.size());
    }

}
