package com.sonic.gof23.singleton;

/**
 * EnumSingleton 懒汉式
 *
 * @author Sonic
 * @since 2019/2/11
 */
public enum EnumSingleton {

    INSTANCE;

    EnumSingleton() {
        System.out.println("Construct...");
    }

    public void doSomething() {
        System.out.println("do something");
    }
}
