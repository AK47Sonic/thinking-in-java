package com.sonic.juc.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

    public static void main(String[] args) {
        ThreadCreation threadCreation = new ThreadCreation();
//        threadCreation.testThread();
//        threadCreation.testRunnable();
        threadCreation.testCallable();
    }

    public void testThread() {
        ThreadCreation.MyThread myThread = new ThreadCreation.MyThread();
        myThread.start();
    }

    public void testRunnable() {
        ThreadCreation.RunnableTask runnableTask = new ThreadCreation.RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
    }

    public void testCallable() {
        FutureTask<String> stringFutureTask = new FutureTask<>(new ThreadCreation.CallerTask());
        new Thread(stringFutureTask).start();

        try {
            String result = stringFutureTask.get();
            System.out.println("result: " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
