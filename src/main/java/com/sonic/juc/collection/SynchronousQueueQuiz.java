package com.sonic.juc.collection;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueueQuiz
 *
 * @author Sonic
 * @since 2019/4/11
 */
public class SynchronousQueueQuiz {

    // 1. SynchronousQueue无空间的，offer 永远返回 false
    // 2. SynchronousQueue take() 方法会被阻塞，必须被其他线程显示地调用put
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Object> queue = new SynchronousQueue<>();
        System.out.println("queue.offer(1) = " + queue.offer(1));
        System.out.println("queue.offer(2) = " + queue.offer(2));
        System.out.println("queue.offer(3) = " + queue.offer(3));
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue.size = " + queue.size());
    }

}
