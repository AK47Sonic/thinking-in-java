package com.sonic.juc.atomic;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * AtomicTest
 *
 * @author Sonic
 * @since 2019/1/18
 */
public class AtomicTest {

    //    private static AtomicLong atomicLong = new AtomicLong();
//    private static LongAdder longAdder = new LongAdder();
    private static LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 7};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 11};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; i++) {
                if (arrayOne[i].intValue() == 0) {
//                    atomicLong.incrementAndGet();
//                    longAdder.increment();
                    longAccumulator.accumulate(1L);
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            int size = arrayTwo.length;
            for (int i = 0; i < size; i++) {
                if (arrayTwo[i].intValue() == 0) {
//                    atomicLong.incrementAndGet();
//                    longAdder.increment();
                    longAccumulator.accumulate(1L);
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

//        System.out.println("count 0: " + atomicLong.get());
//        System.out.println("count 0: " + longAdder.sum());
        System.out.println("count 0: " + longAccumulator.get());

    }

}
