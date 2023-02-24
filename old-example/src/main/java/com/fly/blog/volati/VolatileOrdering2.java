package com.fly.blog.volati;

/**
 * @author 张攀钦
 * @date 2020-06-20-16:02
 */
public class VolatileOrdering2 {
    static volatile  int b = 1;

    public static void main(String[] args) throws InterruptedException {
        int a = 0;




        b +=2;



        a += 1;
        System.out.println(a);
    }
}
