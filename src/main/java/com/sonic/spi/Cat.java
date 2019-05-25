package com.sonic.spi;

/**
 * Cat
 *
 * @author Sonic
 * @since 2019/5/25
 */
public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}