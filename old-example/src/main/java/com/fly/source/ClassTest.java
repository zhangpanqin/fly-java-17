package com.fly.source;

import org.junit.jupiter.api.Test;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2020-06-16-19:08
 */
public class ClassTest {

    static {
        System.out.println("Class Test 静态方法初始化");
    }

    {
        System.out.println("代码块");
    }

    @Test
    public void run22() {
        System.out.println(ClassTest.class.toGenericString());
    }

    @Test
    public void run33(){
        AnnotatedType[] annotatedInterfaces = List.class.getAnnotatedInterfaces();
        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
            System.out.println(annotatedInterface.getType().getTypeName());
        }
    }

    @Test
    public void run44(){
        Type genericSuperclass = ArrayList.class.getGenericSuperclass();
        System.out.println(genericSuperclass.getTypeName());
    }
}
