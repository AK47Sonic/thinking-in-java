package com.sonic.juc.semaphore;

import java.util.concurrent.Semaphore;

/**
 * SemaphoreTest
 *
 * @author Sonic
 * @since 2019/1/21
 */
public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Before Thread name: " + Thread.currentThread().getName() + ", threadOne");
                Thread.sleep(10000);
                System.out.println("After Thread name: " + Thread.currentThread().getName() + ", threadOne");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadTwo = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread name: " + Thread.currentThread().getName() + ", threadTwo");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadOne.start();
        Thread.sleep(1000);
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
    }

}
