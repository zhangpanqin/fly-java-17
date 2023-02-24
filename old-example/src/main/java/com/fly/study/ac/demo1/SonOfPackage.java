package com.fly.study.ac.demo1;

/**
 * @author 张攀钦
 * @date 2020-07-08-13:40
 */
public class SonOfPackage extends Parent {

    public static void main(String[] args) {
        final SonOfPackage sonOfPackage = new SonOfPackage();
        sonOfPackage.ac_default();
        sonOfPackage.ac_protected();
        sonOfPackage.ac_public();
    }
}
