package com.fly.study.guava.collection;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-12-04-21:28
 * @description guava Lists 学习
 */
public class ListsTest {

    @Test
    public void run1() {
        ArrayList<String> objects = Lists.newArrayListWithCapacity(4);
    }

    /**
     * 扩得扩容之后的大小
     */

    @Test
    public void run2() {
        ArrayList<String> objects = Lists.newArrayListWithExpectedSize(4);
        objects.add("1");
        objects.add("1");
        objects.add("1");
        objects.add("1");
        System.out.println(objects);
    }

    /**
     * 扩容之后，再填充数据
     */
    @Test
    public void run3() {
        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
    }

    /**
     * 获取字符串中的位置
     */
    
    @Test
    public void run4() {
        List<Character> characters = Lists.charactersOf("0123456789");
        System.out.println(characters.get(5));
    }

    @Test
    public void run5() {
        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        List<String> reverse = Lists.reverse(strings);
        System.out.println(reverse);

    }


}
