package com.fly.blog.volati;

/**
 * @author 张攀钦
 * @date 2020-06-20-17:54
 * 单例模式
 */
public class SingletonDemo1 {
    private SingletonDemo1() {
    }

    public static SingletonDemo1 getInstance() {
        System.out.println("SingletonDemo1Holder 类加载");
        return SingletonDemo1Holder.getInstance();
    }

    private static class SingletonDemo1Holder {
        private static final SingletonDemo1 INSTANCE = new SingletonDemo1();

        public static SingletonDemo1 getInstance() {
            return SingletonDemo1Holder.INSTANCE;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(SingletonDemo1.getInstance());
        System.out.println(SingletonDemo1.getInstance());
    }
}
