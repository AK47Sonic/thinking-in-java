package com.sonic.gof23.singleton;

/**
 * HungrySingleton
 * 类加载后直接实例化对象
 * @author Sonic
 * @since 2019/12/22
 */
public class HungrySingleton {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}
