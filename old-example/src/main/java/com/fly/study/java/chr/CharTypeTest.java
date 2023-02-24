package com.fly.study.java.chr;

/**
 * @author 张攀钦
 * @date 2019-12-19-12:49
 * @description
 */
public class CharTypeTest {
    public static void main(String[] args) {
        //100 对应十六进制 0064，十六进制对应的是 d
        char a = 100;
        System.out.println(a);
        // d
        char b='\u03A9';
        System.out.println(b);
        // Ω
        char c='\u15D2';
        System.out.println(c);
        // ᗒ
        char d='\u1E0E';
        // Ḏ
        System.out.println(d);
    }

}
