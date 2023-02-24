package com.fly.source.collection;

/**
 * @author 张攀钦
 * @date 2020-08-13-13:45
 */
public class Demo2 {
    transient int a;

    public Demo2(int a) {
        this.a = a;
    }


    public Test1 test22() {
        return new Test1(5);
    }

    private class Test1 {
        private int a;

        Test1(int a) {
            this.a = a;
        }

        public void test() {
            System.out.println(Demo2.this.a);
            System.out.println(this.a);
        }
    }

    public static void main(String[] args) {
        final Demo2 demo2 = new Demo2(10);
        final Test1 test1 = demo2.test22();
        test1.test();
    }

}
