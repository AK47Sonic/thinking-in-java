package com.sonic.juc.collection;

import java.util.concurrent.*;

/**
 * BlockingQueueQuiz
 *
 * @author Sonic
 * @since 2019/4/12
 */
public class BlockingQueueQuiz {

    public static void main(String[] args) throws InterruptedException {
        offer(new ArrayBlockingQueue<>(2));
        offer(new LinkedBlockingQueue<>(2));
        offer(new PriorityBlockingQueue<>(2));
        offer(new SynchronousQueue<>());
    }

    private static void offer(BlockingQueue<Integer> queue) throws InterruptedException {
        System.out.println("queue.getClass() = " + queue.getClass().getName());
        System.out.println("queue.offer(1) = " + queue.offer(1));
        System.out.println("queue.offer(1) = " + queue.offer(2));
        System.out.println("queue.offer(1) = " + queue.offer(3));
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.take() = " + queue.take());

    }

}
