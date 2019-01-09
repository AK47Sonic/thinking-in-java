package com.sonic.juc.yield;

/**
 * YieldMain
 *
 * @auther Sonic
 * @since 2019/1/10
 */
public class YieldMain implements Runnable {
    public YieldMain() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread() + "yield cpu...");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + "is over");
    }

    public static void main(String[] args) {
        new YieldMain();
        new YieldMain();
        new YieldMain();
    }
}
