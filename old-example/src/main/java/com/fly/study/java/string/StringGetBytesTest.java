package com.fly.study.java.string;

import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;

/**
 * @author 张攀钦
 * @date 2019-10-24-22:09
 * @description 学习 String getBytes 返回的数据是什么
 * https://juejin.im/post/5dad9394e51d4531a7423b3a
 */
public class StringGetBytesTest {

    @Test
    public void run43() throws UnsupportedEncodingException {

        // {-28,-72,-108}
        String str ="且";
        final byte[] bytes = str.getBytes("UTF-8");
        StringBuilder stringBuilder =new StringBuilder();

        for (byte aByte : bytes) {
            stringBuilder.append(aByte).append(",");
        }

        System.out.println(stringBuilder.toString());
    }
}
