package com.fly.blog.refect;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2020-07-03-10:39
 */
public class ReflectDemo<T extends List,U> {
    private String name;
    private U u;
    private T data;
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        final Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        final Constructor<?>[] constructors = reflectDemoClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getAnnotatedReturnType().getType().getTypeName());
            System.out.println(constructor.getClass());
            System.out.println(constructor.getName());
            final int modifiers = constructor.getModifiers();
            System.out.println(Modifier.isPublic(modifiers));
            System.out.println(Modifier.isPrivate(modifiers));
            final ReflectDemo o = (ReflectDemo) constructor.newInstance();
            o.test();
        }
    }

    @Test
    public void run44(){
        for (Field field : ReflectDemo.class.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getGenericType().getTypeName());
        }
    }

    public void test(){
        System.out.println(1111);
    }
}
