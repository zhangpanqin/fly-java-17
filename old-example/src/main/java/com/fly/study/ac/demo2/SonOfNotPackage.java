package com.fly.study.ac.demo2;

import com.fly.study.ac.demo1.Parent;

/**
 * @author 张攀钦
 * @date 2020-07-08-13:43
 */
public class SonOfNotPackage extends Parent {
    public static void main(String[] args) {
        final SonOfNotPackage sonOfNotPackage = new SonOfNotPackage();
        sonOfNotPackage.ac_protected();
        sonOfNotPackage.ac_public();
    }
}
