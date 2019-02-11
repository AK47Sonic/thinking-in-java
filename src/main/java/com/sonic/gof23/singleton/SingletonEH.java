package com.sonic.gof23.singleton;

/**
 * SingletonEH 饿汉式
 *
 * @author Sonic
 * @since 2019/2/11
 */
public class SingletonEH {

    private static final SingletonEH INSTANCE = new SingletonEH();

    private SingletonEH() {

    }

    public static SingletonEH getInstance() {
        return INSTANCE;
    }

}
