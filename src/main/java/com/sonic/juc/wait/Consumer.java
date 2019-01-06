package com.sonic.juc.wait;

import java.util.Queue;

/**
 * Consumer
 *
 * @auther Sonic
 * @since 2019/1/6
 */
public class Consumer implements Runnable {

    private static final int MIN_SIZE = 0;
    private Queue<String> queue;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == MIN_SIZE) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " wait");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " consume element");
                queue.remove();
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
