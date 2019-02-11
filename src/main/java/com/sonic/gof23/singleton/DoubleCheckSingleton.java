package com.sonic.gof23.singleton;

/**
 * DoubleCheckSingleton 懒汉式
 *
 * @author Sonic
 * @since 2019/2/11
 */
public class DoubleCheckSingleton {

    /**
     * volatile防止指令重排序，次序必须是1,2,3
     * 1. 给 singleton 分配内存
     * 2. 调用 Singleton 的构造函数来初始化成员变量，形成实例
     * 3. 将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
     *
     */
    private static volatile DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
