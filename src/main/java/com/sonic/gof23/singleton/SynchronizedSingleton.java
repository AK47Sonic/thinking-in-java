package com.sonic.gof23.singleton;

/**
 * SynchronizedSingleton 懒汉式
 *
 * @author Sonic
 * @since 2019/2/11
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance = null;

    private SynchronizedSingleton() {
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

}
