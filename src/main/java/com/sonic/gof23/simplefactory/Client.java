package com.sonic.gof23.simplefactory;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/12
 */
public class Client {

    public static void main(String[] args) {
        Product a = SimpleFactory.getProduct("A");
        a.methodDiff();
        a.methodSame();
    }

}
