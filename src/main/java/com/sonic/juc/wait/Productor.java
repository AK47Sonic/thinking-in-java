package com.sonic.juc.wait;

import java.util.Queue;

/**
 * Productor
 *
 * @author Sonic
 * @since 2019/1/6
 */
public class Productor implements Runnable {

    private Queue<String> queue;
    private static final int MAX_SIZE = 10;

    public Productor(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == MAX_SIZE) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " wait");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " produce element");
                queue.add("Element");
                System.out.println(Thread.currentThread().getName() + " size: " + queue.size());
                queue.notify();

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
