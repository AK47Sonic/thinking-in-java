package com.sonic.juf;

import java.util.function.Consumer;

/**
 * ConsumerAndThenTest
 *
 * @author Sonic
 * @since 2019/2/13
 */
public class ConsumerAndThenTest {

    public static void main(String[] args) {
        Consumer<String> consumer1 = (a) -> {
            System.out.println(a);
        };

        Consumer<String> consumer2 = (a) -> {
            System.out.println("," + a);
        };

        consumer1.andThen(consumer2).accept("Hello");

    }

}
