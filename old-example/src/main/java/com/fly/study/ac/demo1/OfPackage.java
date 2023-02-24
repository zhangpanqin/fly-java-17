package com.fly.study.ac.demo1;

/**
 * @author 张攀钦
 * @date 2020-07-08-13:44
 */
public class OfPackage {
    public static void main(String[] args) {
        final Parent parent = new Parent();
        parent.ac_public();
        parent.ac_default();
        parent.ac_protected();
    }
}
