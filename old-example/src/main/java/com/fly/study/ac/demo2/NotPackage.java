package com.fly.study.ac.demo2;

import com.fly.study.ac.demo1.Parent;

/**
 * @author 张攀钦
 * @date 2020-07-08-13:42
 */
public class NotPackage {
    public static void main(String[] args) {
        final Parent parent = new Parent();
        parent.ac_public();
    }
}
