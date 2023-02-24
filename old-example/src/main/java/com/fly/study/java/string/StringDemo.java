package com.fly.study.java.string;

import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-06-16:22
 * @description
 */
public class StringDemo {
    @Test
    public void run() {
        String str1 = "123";
        String str3 = "123";
        String str2 = new String("123");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }

    @Test
    public void run2() {
        byte a = 0;
        Demo demo = new Demo();
        demo.log(0);
        demo.log(a);
        demo.log(0L);
    }

    @Test
    public void run1() {

        Object o1 = new Object();
        Object o2 = o1;
        o1 = new Object();
        System.out.println(o1==o2);
    }
}

class Demo {

    public void log(long a) {
        System.out.println("long 类型");
    }

    public void log(byte b) {
        System.out.println("字节");
    }

    public void log(int c) {
        System.out.println("int ");
    }

}

class Demo2 extends Demo{
  private int a=0;

  public int b=0;
}