package com.sonic.juc.unsafe;

import sun.misc.Unsafe;

/**
 * TestUnsafe
 *
 * @author Sonic
 * @since 2019/1/15
 */
public class TestUnsafe {

    static final Unsafe unsafe = Unsafe.getUnsafe();
    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnsafe test = new TestUnsafe();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }

}
