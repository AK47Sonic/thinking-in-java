package com.sonic.juc.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueueTest
 *
 * @author Administrator
 * @since 2019/2/3
 */
public class ConcurrentLinkedQueueTest {

    private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {
        queue.offer("Hello");
        queue.offer("World");
        queue.offer("Hello");

        System.out.println("size: " + queue.size());
    }
}
