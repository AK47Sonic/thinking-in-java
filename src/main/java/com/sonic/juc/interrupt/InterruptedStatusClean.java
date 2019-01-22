package com.sonic.juc.interrupt;

/**
 * InterruptedStatusClean
 *
 * @author Sonic
 * @since 2019/1/12
 */
public class InterruptedStatusClean {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
//                while(!Thread.currentThread().isInterrupted()) {

                }
                System.out.println("threadOne is interrupted: " + Thread.currentThread().isInterrupted());
            }
        });

        threadOne.start();

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");

    }
}
