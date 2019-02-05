package com.sonic.juc.executor;

/**
 * ThreadPoolExecutorStatus
 * RUNNING: -536870912 -536870912
 * TERMINATED: 201326592 1610612736
 * TIDYING: 1073741824 1073741824
 * STOP: 536870912 536870912
 * SHUTDOWN: 0 0
 *
 * @author Administrator
 * @since 2019/2/4
 */
public class ThreadPoolExecutorStatus {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println("RUNNING: " + 0b11100000000000000000000000000000 + " " + RUNNING);
        System.out.println("TERMINATED: " + 0b01100000000000000000000000000 + " " + TERMINATED);
        System.out.println("TIDYING: " + 0b01000000000000000000000000000000 + " " + TIDYING);
        System.out.println("STOP: " + 0b00100000000000000000000000000000 + " " + STOP);
        System.out.println("SHUTDOWN: " + 0b00000000000000000000000000000000 + " " + SHUTDOWN);
    }
}
