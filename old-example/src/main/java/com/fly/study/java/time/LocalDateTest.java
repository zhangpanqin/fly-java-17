package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @author 张攀钦
 * @date 2019-10-02-16:19
 * @description DateTime 学习
 */
public class LocalDateTest {

    @Test
    public void run() {
        System.out.println(LocalDate.now());
    }

    @Test
    public void now1() {
        final ZoneId of = ZoneId.of("UTC+8");
        final ZoneId of2 = ZoneId.of("UTC+7");
        System.out.println(LocalDateTime.now(of2));
        System.out.println(LocalDateTime.now(of));
        System.out.println(LocalDate.now(of));
    }


    @Test
    public void run2() {
        System.out.println(LocalDate.of(2020, 12, 12));
    }

    @Test
    public void run3() {
        final LocalDate now = LocalDate.now();
//        返回新的日期
        final LocalDate localDate = now.plusDays(20);
        System.out.println(now == localDate);
        System.out.println(now);
        System.out.println(localDate);
    }

    @Test
    public void run4() {
//        距离格林威治时间的天数
        System.out.println(LocalDate.ofEpochDay(0L));
    }

    @Test
    public void run5() {
        System.out.println(LocalDate.ofEpochDay(400L));
    }

    @Test
    public void run6() {
        final LocalDate now = LocalDate.now();
        final LocalDate from = LocalDate.from(LocalDateTime.now());
        System.out.println(now == from);
        System.out.println(now.equals(from));

    }

    @Test
    public void run7() {
        final LocalDate parse = LocalDate.parse("2020-12-12", DateTimeFormatter.ISO_OFFSET_DATE);
        System.out.println(parse);
    }

    @Test
    public void run8() {
        final LocalDate parse = LocalDate.parse("1970-01-02");
        System.out.println(parse.toEpochDay());
    }


    @Test
    public void run9() {
        final LocalDate parse = LocalDate.parse("1970-01-02");
        System.out.println(parse.isSupported(ChronoField.NANO_OF_SECOND));
    }
}
