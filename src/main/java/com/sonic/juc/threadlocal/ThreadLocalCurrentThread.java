package com.sonic.juc.threadlocal;

/**
 * ThreadLocalCurrentThread
 *
 * @author Sonic
 * @since 2019/1/13
 */
public class ThreadLocalCurrentThread {

    //    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<SharedVal> inheritableThreadLocal = new InheritableThreadLocal<>();
    private static volatile SharedVal sharedVal = new SharedVal();

    public static void main(String[] args) throws InterruptedException {
//        String s = "hello world";
//        threadLocal.set(s);
        inheritableThreadLocal.set(sharedVal);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
//                System.out.println("threadLocal: " + threadLocal.get());
                    System.out.println("inheritableThreadLocal: " + inheritableThreadLocal.get().value);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        System.out.println("main:" + inheritableThreadLocal.get().value);
//        Thread.sleep(1000);
        sharedVal.value = "Change value";
        System.out.println("==============Change value===============");
        System.out.println("main:" + inheritableThreadLocal.get().value);
        System.out.println("main:" + inheritableThreadLocal.get().value);
        System.out.println("main:" + inheritableThreadLocal.get().value);
    }

}
