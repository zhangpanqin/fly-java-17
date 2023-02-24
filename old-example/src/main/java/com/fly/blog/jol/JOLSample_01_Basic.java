package com.fly.blog.jol;

import org.openjdk.jol.info.ClassLayout;
import static java.lang.System.out;

public class JOLSample_01_Basic {
    public static void main(String[] args) throws Exception {
        out.println(ClassLayout.parseInstance(new JOLSample_01_Basic.A()).toPrintable());
    }

    public static class A {
        boolean f;
        int a;byte c;
    }

}