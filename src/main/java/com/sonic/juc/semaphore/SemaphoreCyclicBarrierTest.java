package com.sonic.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreCyclicBarrierTest
 *
 * @author Sonic
 * @since 2019/2/7
 */
public class SemaphoreCyclicBarrierTest {

    private static volatile Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " A task-1 over");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " A task-2 over");
                semaphore.release();
            }
        });

        semaphore.acquire(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " B task-1 over");
                semaphore.release();
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " B task-2 over");
                semaphore.release();
            }
        });

        semaphore.acquire(2);
        System.out.println("Task is over");

        executorService.shutdown();
    }

}
