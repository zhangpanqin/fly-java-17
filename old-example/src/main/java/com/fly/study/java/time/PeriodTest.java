package com.fly.study.java.time;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author 张攀钦
 * @date 2019-10-02-14:56
 * @description Period 学习
 */
public class PeriodTest {
    @Test
    public void run1() {
        final LocalDateTime now = LocalDateTime.now();

        final LocalDate now1 = LocalDate.of(2020,12,12);
        final Period between = Period.between(now.toLocalDate(), now1);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

}
