package com.fly.study.java.string;

import java.io.UnsupportedEncodingException;

/**
 * @author 张攀钦
 * @date 2020-06-06-17:00
 */
public class Str {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "字符串编译之后为 unicode 字符集";

        final String charsetName = "UTF-8";

        // 使用 UTF-8 编码为字节
        final byte[] bytes = str.getBytes(charsetName);

        // 解码为字符串,编码和解码采用同样的编码规则 UTF-8
        final String x = new String(bytes, charsetName);

        // 打印 23383,字 的 16 进制码点为 5B57 转为十进制为 23383
        System.out.println(x.codePointAt(0));
        System.out.println(x);


        final String gbk = "GBK";

        // 使用 GBK 编码为字节
        final byte[] gbks = str.getBytes(gbk);

        // 解码为字符串,编码和解码采用同样的编码规则 GBK
        final String x1 = new String(gbks, gbk);

        // 打印 23383,字 的 16 进制码点为 5B57 转为十进制为 23383
        System.out.println(x1.codePointAt(0));
        System.out.println(x1);
    }
}
