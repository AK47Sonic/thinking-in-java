package com.sonic.juc.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrierMultiStepTest
 *
 * @author Administrator
 * @since 2019/2/7
 */
public class CyclicBarrierMultiStepTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                    cyclicBarrier.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + " step1");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step2");
                    cyclicBarrier.await();

                    System.out.println(Thread.currentThread() + " step3");
                    cyclicBarrier.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();

    }

}
