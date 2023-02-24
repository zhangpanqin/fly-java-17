package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

/**
 * @author 张攀钦
 * @date 2019-10-02-14:23
 * @description Month 学习
 */
public class MonthTest {
    @Test
    public void run1() {
        final LocalDate of = LocalDate.of(1992, 8, 21);
        final MonthDay from = MonthDay.from(of);
        System.out.println(from.getDayOfMonth());
        System.out.println(from.getMonthValue());
        final LocalDateTime of1 = LocalDateTime.of(2019, 8, 21, 0, 2, 0);
        final MonthDay from1 = MonthDay.from(of1);
        System.out.println(from.equals(from1));
    }

}
