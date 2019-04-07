package com.sonic.juc.threadpool;

import java.util.concurrent.*;

/**
 * ThreadPoolExceptionHandler
 *
 * @author Sonic
 * @since 2019/4/5
 */
public class ThreadPoolExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        CustomThreadPoolExecutor executorService = new CustomThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread one");
                    processBusiness();
                }
            });


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread two");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread three");
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("" +  executorService.exceptionCount);

    }

    private static void processBusiness(){
        throw new RuntimeException("Sky");
    }

}
