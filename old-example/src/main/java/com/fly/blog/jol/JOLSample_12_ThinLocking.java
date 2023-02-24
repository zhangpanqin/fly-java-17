package com.fly.blog.jol;

import org.openjdk.jol.info.ClassLayout;
import static java.lang.System.out;

public class JOLSample_12_ThinLocking {
    public static void main(String[] args) throws Exception {
        A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);
        out.println("**** 对象创建,没有经过锁竞争");
        out.println(layout.toPrintable());
        synchronized (a) {
            out.println("**** 获取到锁");
            out.println(layout.toPrintable());
        }
        out.println("**** 锁释放");
        out.println(layout.toPrintable());
    }

    public static class A {
    }
}