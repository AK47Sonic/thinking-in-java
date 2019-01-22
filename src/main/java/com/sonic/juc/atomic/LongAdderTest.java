package com.sonic.juc.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdderTest
 *
 * @author Sonic
 * @since 2019/1/19
 */
public class LongAdderTest {

    static LongAdder longAdder = new LongAdder();
    static final long MAX_VALUE =1000;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable task = () -> {
            long sum = longAdder.sum();
            while (sum < MAX_VALUE) {
                longAdder.increment();
                sum = longAdder.sum();
            }
            System.out.println("longAdder sum: " + sum);
        };

        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }

    }

}
