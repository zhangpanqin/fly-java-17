package com.fly.study.guava.collection;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-12-05-10:40
 * @description
 */
public class ImmutableListDemo {
    @Test
    public void run1() {
        ImmutableList<String> build = ImmutableList.<String>builder().addAll(List.of("1", "2")).build();
        System.out.println(build);
    }

}
