package com.fly.source.time;

import org.junit.jupiter.api.Test;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 张攀钦
 * @date 2020-07-16-14:00
 */
public class ZoneIdTest {

    @Test
    public void run1() {
        final ZoneId of = ZoneId.of("UTC+8");
        final ZoneId of1 = ZoneId.of("+8");
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.system(of).millis());
        System.out.println(Clock.system(of1).millis());
        System.out.println(Clock.systemUTC().millis());
    }

    @Test
    public void run2() {
        final ZoneId of = ZoneId.of("UTC+8");
        final ZonedDateTime now = ZonedDateTime.now(of);
        final LocalDateTime localDateTime = now.toLocalDateTime();
        System.out.println(localDateTime.getYear());
    }

    @Test
    public void run3() {
        final Period period = Period.ofWeeks(52);
        System.out.println(period.getYears());
        System.out.println(period.getDays());
    }

    @Test
    public void run43() {
        final ZoneId of = ZoneId.of("UTC+8");
        final LocalTime now = LocalTime.now(of);
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
    }

    @Test
    public void run444() {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf(dateTimeFormatter.format(LocalDateTime.now()));
    }
}
