package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author 张攀钦
 * @date 2019-10-02-12:40
 * @description ZoneId 学习
 */
public class ZoneIdTest {
    @Test
    public void run1() {
        final ZoneId of = ZoneId.of("UTC+8");
        System.out.println(LocalDateTime.now(of));
    }

    @Test
    public void run2() {
        final ZoneId of = ZoneId.of("Asia/Shanghai");
        System.out.println(LocalDateTime.now(of));

    }

    @Test
    public void run3() {
        final ZoneId of = ZoneId.of("UTC+8");
        final ZoneId of1 = ZoneId.of("Asia/Shanghai");
        System.out.println(of.equals(of1));
        System.out.println(ZoneId.systemDefault());
    }

}
