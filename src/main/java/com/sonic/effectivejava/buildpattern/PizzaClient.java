package com.sonic.effectivejava.buildpattern;

import static com.sonic.effectivejava.buildpattern.Pizza.Topping.HAM;

/**
 * PizzaClient
 *
 * @author Sonic
 * @since 2019/3/16
 */
public class PizzaClient {
    public static void main(String[] args) {
        Pizza calzone = new Calzone.Builder(true).addTopping(HAM).build();
        System.out.println(calzone);
    }
}
