package com.sonic.juc.collection;

import java.util.Arrays;
import java.util.List;

/**
 * ArraysAsListMethodQuestion
 *
 * @author Sonic
 * @since 2019/4/10
 */
public class ArraysAsListMethodQuestion {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.set(3, 9);
        list.forEach(System.out::println);
        // Java < 5, Vector Collections.synchronizedList
        // Java 5+ CopyOnWriteArrayListDemo
        // Java 9+ List.of 只读

    }

}
