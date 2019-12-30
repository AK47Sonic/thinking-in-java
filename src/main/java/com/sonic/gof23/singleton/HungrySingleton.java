package com.sonic.gof23.singleton;

import java.io.Serializable;

/**
 * HungrySingleton
 * 类加载后直接实例化对象
 *
 * @author Sonic
 * @since 2019/12/22
 */
public class HungrySingleton implements Serializable {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    /**
     * ObjectInputStream中会调用以下方法，进行重新赋值，这时候堆里面已经有单例对象了。
     * Object rep = desc.invokeReadResolve(obj);
     */
    private Object readResolve() {
        return hungrySingleton;
    }

}


