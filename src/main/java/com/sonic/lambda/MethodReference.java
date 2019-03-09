package com.sonic.lambda;

import java.util.function.Predicate;

/**
 * MethodReference
 *
 * @author Sonic
 * @since 2019/3/9
 */
public class MethodReference {

    public static void main(String[] args) {
        Predicate<String> predicate = e -> "".equals(e);
        test("Hello", predicate);
        test("Hello", MethodReference::getPredicate);
    }

    public static boolean test(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }

    public static boolean getPredicate(String s) {
        return "".equals(s);
    }

}
