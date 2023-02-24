package com.fly.study.java.lang;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

/**
 * @author 张攀钦
 * @date 2019-10-25-11:26
 * @description 学习 Study
 */
public class StringStudyTest {

    @Test
    public void run1() {
        String str = "GeeksforGeeks.";

        // Concatenation of two strings
        String gfg1 = String.format("My Company name is %1$s %1$s", str);

        // Output is given upto 8 decimal places
        String str2 = String.format("My answer is %.8f", 47.65734);

        // between "My answer is" and "47.65734000" there are 15 spaces
        String str3 = String.format("My answer is %15.8f", 47.65734);

        // 日期
        String str4=String.format("日期4：%tF", LocalDateTime.now());
        String str5=String.format("日期5：%1$tY-%1$tm-%1$td %1$tT", LocalDateTime.now());

        System.out.println(gfg1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
    }
}
