package com.fly.study.java.generics;

/**
 * @author 张攀钦
 * @date 2019-09-16-07:41
 * @description 泛型在继承中的使用
 */
public interface TestService<T> {

    T getT(T t);
}
