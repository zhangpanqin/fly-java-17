package com.fly.study.java.string;

import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;

/**
 * @author 张攀钦
 * @date 2019-12-04-9:27
 * @description
 */
public class Encoding {

    @Test
    public void run11() {
        System.out.println(System.getProperty("file.encoding"));
    }

    @Test
    public void run100() throws UnsupportedEncodingException {
        String str = "张攀钦";
        final byte[] gbks = str.getBytes("GBK");
        final String s = new String(gbks, "UTF-8");

        final byte[] error_s = s.getBytes("UTF-8");
        System.out.println(new String(error_s,"GBK"));
    }
}
