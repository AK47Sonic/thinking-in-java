package com.sonic.gof23.simplefactory;

/**
 * SimpleFactory
 *
 * @author Sonic
 * @since 2019/3/12
 */
public class SimpleFactory {

    public static Product getProduct(String type) {
        if (type.equalsIgnoreCase("A")) {
            return new ProductA();
        } else if (type.equalsIgnoreCase("B")) {
            return new ProductB();
        }
        return null;
    }
}
