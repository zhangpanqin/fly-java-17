package com.fly.study.java.generics;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-09-21-18:05
 * @description jdk 1.5 之前
 */
public class Jdk5 {


    @Test
    public void run1() {
//        有个集合你想保存 String 类型数据
        List list =new ArrayList();

        list.add("1111");

        String o = (String) list.get(0);
        System.out.println(o.length());

        // 可能会导致别的开发人员存储的是 int 类型
        list.add(2222);
    }

    @Test
    public void run2() {
//        有个集合你想保存 String 类型数据
        List<String> list =new ArrayList();

        list.add("1111");

        String s = list.get(0);
        System.out.println(s.length());

        // 可能会导致别的开发人员存储的是 int 类型
        //        list.add(2222);
    }
}
