package com.sonic.juc.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomMultiThread
 *
 * @auther Sonic
 * @since 2019/1/17
 */
public class RandomMultiThread {
    static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; ++i)
                System.out.println(Thread.currentThread().getName() + ": " + threadLocalRandom.nextInt(5));
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; ++i)
                System.out.println(Thread.currentThread().getName() + ": " + threadLocalRandom.nextInt(5));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main is over");

    }
}
