package com.sonic.juc.creation;

import java.util.concurrent.Callable;

/**
 * Use Thread
 *
 * @auther Sonic
 * @since 2019/1/5
 */
public class ThreadCreation {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    public static class CallerTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(100);
            return "Hello";
        }
    }

}
