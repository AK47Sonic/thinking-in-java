package com.sonic.juc.threadlocal;

/**
 * ThreadLocalSample
 *
 * @auther Sonic
 * @since 2019/1/13
 */
public class ThreadLocalSample {

    private static ThreadLocal<String> localVariable = new ThreadLocal<>();
    private String s;

    public static void main(String[] args) {

        ThreadLocalSample tls = new ThreadLocalSample();

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                tls.s = "threadOne local variable";
                localVariable.set(tls.s);
                print("threadOne");
                System.out.println("threadOne remove after" + ":" + localVariable.get());
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                tls.s = "threadTwo local variable";
                localVariable.set(tls.s);
                print("threadTwo");
                System.out.println("threadTwo remove after" + ":" + localVariable.get());
            }
        });

        threadOne.start();
        threadTwo.start();

    }

    private static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }

}
