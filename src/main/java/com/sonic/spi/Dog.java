package com.sonic.spi;

/**
 * Dog
 *
 * @author Sonic
 * @since 2019/5/25
 */
public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}
