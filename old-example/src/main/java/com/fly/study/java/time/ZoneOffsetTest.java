package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author 张攀钦
 * @date 2019-10-02-14:34
 * @description
 */
public class ZoneOffsetTest {
    
    @Test
    public void run1() {
        final ZoneOffset of = ZoneOffset.of("+8");
        final ZoneId of1 = ZoneId.of("UTC+8");
        System.out.println(LocalDateTime.now(of1));
        final LocalDateTime now = LocalDateTime.now(of);
        System.out.println(now.toEpochSecond(of));
        System.out.println(System.currentTimeMillis());
        System.out.println(now);
        System.out.println(LocalDateTime.now().toEpochSecond(of));
    }

}
