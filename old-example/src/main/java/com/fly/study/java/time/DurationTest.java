package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author 张攀钦
 * @date 2019-10-02-14:04
 * @description Duration 学习
 */
public class DurationTest {
    @Test
    public void run1() {
        final Duration duration = Duration.ofMinutes(1L);
        System.out.println(duration.getSeconds());
    }

    @Test
    public void run2() {
        final LocalDateTime now1 = LocalDateTime.now(ZoneOffset.of("+7"));
        final LocalDateTime now = LocalDateTime.now();
        final Duration between = Duration.between(now1, now);
        System.out.println(between.getSeconds());
    }

}
