package com.fly.study.java.string;

import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2019-11-18-20:50
 * @description 学习 @link String 的 Api
 * {@link java.lang.String}
 * {@link StandardCharsets 获取字符串编码规则}
 */
public class StringStudyTest {


    @Test
    public void run1() {
        String a = "a";
        System.out.println(a);
        String b = "\u261d";
        System.out.println(b);// ☝
        String ding = "\u4E01";
        String ding2 = "丁";
        System.out.println(ding);// 丁
        System.out.println("\u2721");
    }

    @Test
    public void run2() {
//        专、且 码点的十进制
        int[] strCodePoint = {19987, 19988};
        final String s = new String(strCodePoint, 0, 2);
        System.out.println(s);
    }

    @Test
    public void length() {
        System.out.println("\u261d".length());
    }

    @Test
    public void charAt() {
//        c
        System.out.println("abc张".charAt(2));
    }

    @Test
    public void codePointAt() {
        // 获取某个索引上的码点 98
        System.out.println("abc".codePointAt(1));
    }

    @Test
    public void codePointBefore() {
        // 获取某个索引上的码点 99,索引-1 的码点数
        System.out.println("cdbc".codePointBefore(3));
    }

    @Test
    public void indexOf() {
        int i = "adc".indexOf("d");
        // 1
        System.out.println(i);

        // 3    参数为：码点对应的十进制
        System.out.println("acc丰cb".indexOf(20016));
    }


    @Test
    public void run33() throws UnsupportedEncodingException {
        String str ="赵";
        final byte[] bytes = str.getBytes("GBK");
        StringBuilder stringBuilder =new StringBuilder();

        for (byte aByte : bytes) {
            stringBuilder.append(aByte).append(",");
        }
        // -43,-44
        System.out.println(stringBuilder.toString());
    }
}
