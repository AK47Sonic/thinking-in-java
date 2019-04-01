package com.sonic.juc.unsafe;

import java.lang.reflect.Field;

/**
 * UnsafeDemo
 *
 * @author Sonic
 * @since 2019/4/1
 */
public class UnsafeDemo {

    private String value = "hello";

    private static String staticValue = "World";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(UnsafeDemo.class.getClassLoader());

        UnsafeDemo unsafeDemo = new UnsafeDemo();
        Field valueField = UnsafeDemo.class.getDeclaredField("value");
        valueField.setAccessible(true);
        unsafeDemo.value = "reset hello";
        Object obj = valueField.get(unsafeDemo);
        System.out.println("valueField:" + obj);

        Field staticValueField = UnsafeDemo.class.getDeclaredField("staticValue");
        staticValueField.setAccessible(true);
        UnsafeDemo.staticValue = "reset World";
        Object staticObj = staticValueField.get(null);
        System.out.println("staticValue:" + staticObj);

    }

}
