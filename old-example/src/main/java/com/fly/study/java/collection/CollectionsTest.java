package com.fly.study.java.collection;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-12-04-22:01
 * @description Collections 学习
 */
public class CollectionsTest {

    /**
     * 返回不可变集合
     */
    @Test
    public void run1() {
        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        List<String> strings1 = Collections.unmodifiableList(strings);
    }

}
