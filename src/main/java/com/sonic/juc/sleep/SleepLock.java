package com.sonic.juc.sleep;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SleepLock
 * lock 如果不unlock, 即使线程A已经结束，其他线程仍然无法访问
 *
 * @author Sonic
 * @since 2019/1/7
 */
public class SleepLock {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("child threadA is in sleep");
                Thread.sleep(5000);
                System.out.println("child threadA is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("child threadA is over");
        });

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("child threadB is in sleep");
                Thread.sleep(5000);
                System.out.println("child threadB is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("child threadB is over");
        });

        threadA.start();
        threadB.start();

    }
}
