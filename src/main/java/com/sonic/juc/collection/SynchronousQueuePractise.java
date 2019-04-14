package com.sonic.juc.collection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueuePractise
 *
 * @author Sonic
 * @since 2019/4/14
 */
public class SynchronousQueuePractise {

    // 用offer必须先有take，危险！
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        SynchronousQueue<Integer> sQueue = new SynchronousQueue<>();

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                sQueue.offer(1);
//                sQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                sQueue.offer(2);
//                sQueue.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                sQueue.offer(3);
//                sQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                Integer ele = sQueue.take();
                System.out.println(Thread.currentThread().getName() + " ele: " + ele);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                Integer ele = sQueue.take();
                System.out.println(Thread.currentThread().getName() + " ele: " + ele);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                Integer ele = sQueue.take();
                System.out.println(Thread.currentThread().getName() + " ele: " + ele);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
