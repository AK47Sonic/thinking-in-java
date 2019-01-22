package com.sonic.juc.interrupt;

/**
 * SleepInterruptedException
 *
 * @author Sonic
 * @since 2019/1/12
 */
public class SleepInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin sleep for 2000 seconds");
                try {
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    System.out.println("interrupted status: " + Thread.currentThread().isInterrupted());
                    return;
                }
                System.out.println("threadOne-leaving normally");
            }
        });
        threadOne.start();

        Thread.sleep(1000);

        threadOne.interrupt();

        threadOne.join();

        System.out.println("main thread is over");

    }
}
