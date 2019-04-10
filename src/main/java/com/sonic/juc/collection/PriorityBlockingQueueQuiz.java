package com.sonic.juc.collection;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueueQuiz
 *
 * @author Sonic
 * @since 2019/4/11
 */
public class PriorityBlockingQueueQuiz {

    // put不阻塞，插入对象会做排序，默认自然顺序，参照元素Comparable实现，或者显示地传递Comparator
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Object> queue = new PriorityBlockingQueue<>(2);
        queue.put(9);
        queue.put(1);
        queue.put(8);
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.take() = " + queue.take());
        System.out.println("queue = " + queue);
    }

}
