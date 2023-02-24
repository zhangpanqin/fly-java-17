package com.fly.study.net;


import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author 张攀钦
 * @date 2020-08-10-11:01
 */
public class URLDecoderDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        final String decode = URLDecoder.decode("http%3A%2F%2Flocalhost%3A%2Fas%3Fa%3D%E5%BC%A0%E6%94%80%E9%92%A6", "UTF-8");
        System.out.println(decode);
    }

    @Test
    public void run2() throws UnsupportedEncodingException {
        final String decode = URLEncoder.encode("http://localhost:/as?a=张攀钦", "UTF-8");
        System.out.println(decode);
    }
}
