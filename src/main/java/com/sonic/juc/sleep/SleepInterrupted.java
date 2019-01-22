package com.sonic.juc.sleep;

/**
 * SleepInterrupted
 *
 * @author Sonic
 * @since 2019/1/7
 */
public class SleepInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("child thread is in sleep");
                Thread.sleep(5000);
                System.out.println("child thread is in awaked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("child thread is over");
        });

        thread.start();

        Thread.sleep(2000);

        thread.interrupt();

    }
}
