package com.sonic.gof23.singleton;

/**
 * LazyDoubleCheckSingleton
 *
 * @author Sonic
 * @since 2019/12/22
 */
public class LazyDoubleCheckSingleton {

//volatile 防止指令重排序
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    // 2，3 的顺序可能会被重排序
                    // 1. 分配给这个对象内存
                    // 2. 初始化对象
                    // 3. 设置lazyDoubleCheckSingleton 指向刚分配的内存地址
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }

}
