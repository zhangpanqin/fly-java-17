
package com.fly.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 张攀钦
 * @date 2020-07-01-15:01
 */
public class AnnotationDemo {

    public void test(@Parameter(value = "111") int a) {
        @TypeParameter @LocalVariable int b = 1;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface Parameter {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE_USE)
    public @interface TypeParameter {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PACKAGE)
    public @interface Package {
        String value() default "";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.LOCAL_VARIABLE)
    public @interface LocalVariable {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Ab {
    }


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @Ab
    public @interface Ab2 {
    }
}

