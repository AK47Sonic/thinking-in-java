package com.sonic.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadPoolTest
 *
 *             // Check if queue empty only if necessary.
 *             if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
 *                 decrementWorkerCount();
 *                 return null;
 *             }
 *
 * @author Sonic
 * @since 2019/2/9
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("Running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();
        System.out.println("All is completed");
    }
}
