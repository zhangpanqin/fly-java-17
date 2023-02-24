package com.fly.source;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2020-06-16-11:18
 */
public class Lambda {

    /**
     * 测试,抛出异常有什么影响
     */

    @Test
    public void run22() {
        ArrayList<String> strings = Lists.newArrayList("1", "2", "3", "4", "5");

        try {
            strings.stream().forEachOrdered(item -> {
                if (Objects.equals("3", item)) {
                    throw new RuntimeException("抛出异常");
                }
                System.out.println(item);
            });
        } catch (Exception e) {
            System.out.println("捕获到异常了");
        }
    }
}