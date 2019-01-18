package com.sonic.juc.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TestUnSafeRight
 *
 * @auther Sonic
 * @since 2019/1/15
 */
public class TestUnSafeRight {

    static final Unsafe unsafe;
    static final long stateOffset;
    public volatile long state = 0;

    static {
        try {
            Field theUnsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeField.setAccessible(true);
            unsafe = (Unsafe) theUnsafeField.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnSafeRight.class.getDeclaredField("state"));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public void test() {
        System.out.println("ClassLoader: " + getClass().getClassLoader());
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        TestUnSafeRight testUnSafeRight = new TestUnSafeRight();
        boolean success = unsafe.compareAndSwapLong(testUnSafeRight, stateOffset, 0, 1);
        System.out.println("success: " + success + ", state: " + testUnSafeRight.state);

        Method method = TestUnSafeRight.class.getMethod("test", null);
        Object invoke = method.invoke(testUnSafeRight, null);

    }

}
