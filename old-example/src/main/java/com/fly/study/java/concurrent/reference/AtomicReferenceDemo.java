package com.fly.study.java.concurrent.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 张攀钦
 * @date 2020-02-14-06:59
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private int age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User a = new User("A", 12);
        User b =new User("B",13);
        AtomicStampedReference<User> user = new AtomicStampedReference<>(a,0);
        System.out.println(user.compareAndSet(a, b,0,1));
        System.out.println(user.compareAndSet(b, a,1,3));
        System.out.println(user.compareAndSet(a, b,2,4));
        int stamp = user.getStamp();
        User reference = user.getReference();
        System.out.println(user.compareAndSet(reference, b,stamp,stamp));

    }
    public static void  demo(){
        User a = new User("A", 12);
        User b =new User("B",13);
        AtomicReference<User> user = new AtomicReference<>(a);
        System.out.println(user.compareAndSet(a, b));
        System.out.println(user.compareAndSet(b, a));
        System.out.println(user.compareAndSet(a, b));
    }
}
