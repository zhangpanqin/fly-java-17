package com.fly.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 张攀钦
 * @date 2020-07-01-15:22
 */
public class AnnotationDemo2 {

    public static void main(String[] args) {
        System.out.println(Demo2.class.getAnnotation(AnWithExtends.class));
        System.out.println(Demo2.class.getAnnotation(AnWithNoExtends.class));
    }

    @AnWithExtends
    @AnWithNoExtends
    public static class Demo1 {
    }

    public static class Demo2 extends Demo1 {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Target(ElementType.TYPE)
    public @interface AnWithExtends{}


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface AnWithNoExtends{}
}
