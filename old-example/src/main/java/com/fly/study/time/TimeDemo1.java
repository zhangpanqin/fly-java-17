package com.fly.study.time;

import org.junit.jupiter.api.Test;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author 张攀钦
 * @date 2020-08-10-15:29
 */
public class TimeDemo1 {

    @Test
    public void run1() {
        // 1597044583935
        // 1597044668974
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void run2(){
        Instant.now();
    }

    @Test
    public void run444(){
        final LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC+8"));
        final long epochSecond = now.toInstant(ZoneOffset.of("+8")).getEpochSecond();
    }

    @Test
    public void run5(){
        final Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone());
    }
}
