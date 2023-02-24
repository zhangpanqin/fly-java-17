package com.fly.study.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author 张攀钦
 * @date 2020-07-01-15:22
 */
public class AnnotationDemo3 {

    public static void main(String[] args) {

    }

    @An("1")
    @An("2")
    public static class Demo4 {
    }

    @Repeatable(Ans.class)
    @interface An {
        String value();
    }


    @Retention(RetentionPolicy.RUNTIME)
    @interface Ans {
        An[] value();
    }
}

