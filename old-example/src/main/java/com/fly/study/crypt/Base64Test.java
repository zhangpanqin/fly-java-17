package com.fly.study.crypt;

import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 张攀钦
 * @date 2019-12-09-9:30
 * @description
 */
public class Base64Test {

    @Test
    public void run1() throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();
        String s = encoder.encodeToString("张攀钦".getBytes(StandardCharsets.UTF_8));
        byte[] decode = Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(decode, "utf-8"));
    }
}
