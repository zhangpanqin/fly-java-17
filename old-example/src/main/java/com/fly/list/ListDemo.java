package com.fly.list;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * @author 张攀钦
 * @date 2020-08-12-15:43
 */
public class ListDemo {
    @Test
    public void run1() {
        final List<String> strings = Arrays.asList("1", "2");
        strings.set(1, "3");
        System.out.println(strings);
    }

    @Test
    public void run2() {
        final List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        final Spliterator<String> spliterator = strings.stream().spliterator();

    }
}
