package com.sonic.juc.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrierTest
 *
 * @author Administrator
 * @since 2019/2/7
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("NumberWaiting: " + cyclicBarrier.getNumberWaiting());
            System.out.println(Thread.currentThread() + "task1 merge result");
        }
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                // ctrl + alt + t add try catch
                try {
                    System.out.println(Thread.currentThread() + " task1-1");
                    System.out.println(Thread.currentThread() + " enter in barrier");
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread() + " enter out barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " task1-2");
                    System.out.println(Thread.currentThread() + " enter in barrier");
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread() + " enter out barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Shut down thread pool");
        System.out.println("Sleep is over");
//        Thread.sleep(2000);
//        cyclicBarrier.reset();
        executorService.shutdown();

    }
}
