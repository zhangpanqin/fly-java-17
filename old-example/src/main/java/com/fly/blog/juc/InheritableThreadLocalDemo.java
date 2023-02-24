package com.fly.blog.juc;

/**
 * @author 张攀钦
 * @date 2020-06-27-21:18
 */
public class InheritableThreadLocalDemo {
    static InheritableThreadLocal<String> INHERITABLE_THREAD_LOCAL = new InheritableThreadLocal();
    static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        INHERITABLE_THREAD_LOCAL.set("父线程中使用 InheritableThreadLocal 设置变量");
        THREAD_LOCAL.set("父线程中使用 ThreadLocal 设置变量");
        Thread thread = new Thread(
                () -> {
                    Thread thread2 = new Thread(
                            () -> {
                                System.out.println("从 InheritableThreadLocal 拿父父线程设置的变量: " + INHERITABLE_THREAD_LOCAL.get());
                                System.out.println("从 ThreadLocal 拿父父线程设置的变量: " + THREAD_LOCAL.get());
                            }
                    );
                    thread2.start();
                    try {
                        thread2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("从 InheritableThreadLocal 拿父线程设置的变量: " + INHERITABLE_THREAD_LOCAL.get());
                    System.out.println("从 ThreadLocal 拿父线程设置的变量: " + THREAD_LOCAL.get());
                    INHERITABLE_THREAD_LOCAL.set("2222");

                    Thread thread3 = new Thread(
                            () -> {
                                System.out.println("从 InheritableThreadLocal 拿thread程设置的变量: " + INHERITABLE_THREAD_LOCAL.get());
                                System.out.println("从 ThreadLocal 拿thread设置的变量: " + THREAD_LOCAL.get());
                            }
                    );
                    thread3.start();
                    try {
                        thread3.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
        thread.join();
        System.out.println(INHERITABLE_THREAD_LOCAL.get());
    }
}
