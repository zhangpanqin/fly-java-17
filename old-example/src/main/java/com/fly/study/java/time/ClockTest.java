package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.Clock;
import java.time.ZoneId;

/**
 * @author 张攀钦
 * @date 2019-10-02-13:37
 * @description Clock 测试
 */
public class ClockTest {
    @Test
    public void run1() {
        final Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        final Clock system = Clock.system(ZoneId.of("UTC+8"));
        System.out.println(system.millis());
        final Clock system2 = Clock.system(ZoneId.of("UTC+9"));
        System.out.println(system2.millis());
        System.out.println(System.currentTimeMillis());
    }

}
