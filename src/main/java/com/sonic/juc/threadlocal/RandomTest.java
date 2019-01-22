package com.sonic.juc.threadlocal;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomTest
 *
 * @author Sonic
 * @since 2019/1/17
 */
public class RandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < 10; ++i)
        System.out.println(Thread.currentThread().getName() + ": " + threadLocalRandom.nextInt(5));
    }
}
