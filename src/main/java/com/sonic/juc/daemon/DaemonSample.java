package com.sonic.juc.daemon;

/**
 * DaemonSample
 *
 * @auther Sonic
 * @since 2019/1/13
 */
public class DaemonSample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        thread.start();
        System.out.println("main thread is over");
    }
}
