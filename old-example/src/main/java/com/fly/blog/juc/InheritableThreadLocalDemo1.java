package com.fly.blog.juc;

/**
 * @author 张攀钦
 * @date 2020-06-27-21:18
 */
public class InheritableThreadLocalDemo1 {
    static InheritableThreadLocal<String> INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal();
    public static void main(String[] args) throws InterruptedException {
        INHERITABLE_THREAD_LOCAL.set("张攀钦");
        Thread thread = new Thread(
                () -> {
                    // 先验证孙子 thread1 可以拿到 main 线程中设置的数据
                    Thread thread1 = new Thread(() ->System.out.println("线程 thread1 从 InheritableThreadLocal 拿到 main 线程设置数据: " + INHERITABLE_THREAD_LOCAL.get()), "thread1");
                    thread1.start();

                    try {thread1.join(); } catch (InterruptedException e) {e.printStackTrace();}

                    // 子线程 thread0 也可以拿到父线程中设置的数据
                    System.out.println("线程 thread0 从 InheritableThreadLocal 拿到父线程设置的数据: " + INHERITABLE_THREAD_LOCAL.get());

                    // 子线程 thread0 修改数据,主要用于验证,不会改到父线程的数据
                    INHERITABLE_THREAD_LOCAL.set("thread0");

                    // thread2 可以拿到父线程 thread1 设置的数据 thread0
                    Thread thread2 = new Thread(() ->System.out.println("线程 thread2 从 InheritableThreadLocal 拿到 thread0 程设置的变量: " + INHERITABLE_THREAD_LOCAL.get()), "thread2");
                    thread2.start();
                    try {thread2.join(); } catch (InterruptedException e) {e.printStackTrace();}
                }
                , "thread0");
        thread.start();
        thread.join();
        // main 拿到的还是自己初始设置的 main
        System.out.println(INHERITABLE_THREAD_LOCAL.get());
    }
}
