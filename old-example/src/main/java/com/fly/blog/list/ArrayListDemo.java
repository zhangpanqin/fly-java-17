package com.fly.blog.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2020-08-13-21:39
 */
public class ArrayListDemo {

    private List<String> data;

    @BeforeEach
    public void before() {
        data = new ArrayList<>(5);
        data.add("a");
        data.add("b");
        data.add("c");
        data.add("d");
        data.add("e");
    }

    @Test
    public void simple() {
        // a
        System.out.println(data.get(0));
        // e
        System.out.println(data.get(4));
        // 5
        System.out.println(data.size());
    }

    @Test
    public void set() {
        data.set(2, "33");
        // [a, b, 33, d, e]
        System.out.println(data);
    }

    @Test
    public void add() {
        data.add(2, "33");
        // [a, b, 33, c, d, e]
        System.out.println(data);
    }

    @Test
    public void remove() {
        // 移除索引为 2 的元素 c
        data.remove(2);
        // [a, b, d, e]
        System.out.println(data);
    }

    @Test
    public void removeAll() {
        data.removeAll(Arrays.asList("a", "d", "e"));
        // [b, c]
        System.out.println(data);
    }

    @Test
    public void retainAll(){
        data.retainAll(Arrays.asList("a", "e"));
        // [a, e]
        System.out.println(data);
    }
}
