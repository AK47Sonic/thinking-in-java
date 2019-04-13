package com.sonic.juc.thread;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * FutureTaskDemo
 *
 * @author Sonic
 * @since 2019/4/13
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        FutureTask f = new FutureTask<Integer>(() -> {
            System.out.println("Hello");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },1);

        Thread t = new Thread(f);
        t.start();

        f.cancel(false);
        System.out.println("Cancel");

    }
}
