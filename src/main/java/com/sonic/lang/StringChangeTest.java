package com.sonic.lang;

import java.lang.reflect.Field;

/**
 * StringChangeTest
 *
 * @author Sonic
 * @since 2019/2/10
 */
public class StringChangeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = "Hello";
        String b = new String("Hello");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(b, "World".toCharArray());
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
