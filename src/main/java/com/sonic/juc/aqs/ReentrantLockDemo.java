package com.sonic.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 *
 * @author Sonic
 * @since 2019/3/29
 */
public class ReentrantLockDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("Thread:" + Thread.currentThread() + " threadA lock");
                reentrantLock.unlock();
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("Thread:" + Thread.currentThread() + " threadB lock");
                reentrantLock.unlock();
            }
        };

        Thread threadC = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("Thread:" + Thread.currentThread() + " threadC lock");
                reentrantLock.unlock();
            }
        };

        threadA.start();
        threadB.start();
        threadC.start();

        Thread.sleep(3000);
        threadB.interrupt();

        threadA.join();
        threadB.join();
        threadC.join();

    }

}
