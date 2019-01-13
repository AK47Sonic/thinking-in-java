package com.sonic.juc.threadlocal;

/**
 * ThreadLocalCurrentThread
 *
 * @auther Sonic
 * @since 2019/1/13
 */
public class ThreadLocalCurrentThread {

//    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        String s = "hello world";
//        threadLocal.set(s);
        inheritableThreadLocal.set(s);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("threadLocal: " + threadLocal.get());
                System.out.println("inheritableThreadLocal: " + inheritableThreadLocal.get());
            }
        });
        thread.start();

//        System.out.println("main:" + threadLocal.get());
        System.out.println("main:" + inheritableThreadLocal.get());
    }

}
