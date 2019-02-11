package com.sonic.gof23.singleton;

/**
 * InnerClassSingleton 懒汉式
 * 1. 只有静态内部类才能定义静态属性，成员内部类不能定义静态属性
 * 2. 静态内部类内是饿汉式
 * 3. 外部类是懒汉式，只有方法被调用才加载内部类
 *
 * @author Sonic
 * @since 2019/2/11
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {

    }

    private static class InnerInstance {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerInstance.INSTANCE;
    }

}
