package com.fly.blog.jol;

import org.openjdk.jol.info.ClassLayout;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

/**
 * @author Aleksey Shipilev
 */
public class JOLSample_13_BiasedLocking {
    public static void main(String[] args) throws Exception {
        TimeUnit.SECONDS.sleep(6);
        final A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);
        out.println("**** Fresh object");
        out.println(layout.toPrintable());
        synchronized (a) {
            out.println("**** With the lock");
            out.println(layout.toPrintable());
        }
        out.println("**** After the lock");
        out.println(layout.toPrintable());
    }
    public static class A {
        // no fields
    }
}
