package com.sonic.juc.thread;

/**
 * CatchExceptionThread
 *
 * @author Sonic
 * @since 2019/4/8
 */
public class CatchExceptionThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("MyException");
        }, "线程1");

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(t.getName() + " , " + e);
        });
        thread.start();

    }
}
