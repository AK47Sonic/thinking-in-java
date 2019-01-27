package com.sonic.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * ParkInterruptTest
 *
 * @author Administrator
 * @since 2019/1/27
 */
public class ParkInterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            System.out.println("Child thread begin park!");
            while (!Thread.interrupted()) {
                LockSupport.park();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println("----");
            }
            System.out.println("End par!");
        });

        threadOne.start();
        Thread.sleep(5000);
        System.out.println("Main thread begin unpark!");
        threadOne.interrupt();
//        LockSupport.unpark(threadOne);
    }

}
