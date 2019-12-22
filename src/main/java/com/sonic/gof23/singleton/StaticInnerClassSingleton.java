package com.sonic.gof23.singleton;

/**
 * StaticInnerClassSingleton
 * 类初始化条件
 * 1. A类型的实例被创建
 * 2. A类中申明的一个静态方法被调用
 * 3. A类中申明的一个静态成员被赋值
 * 4. A类中申明的一个静态成员被使用， 并且这个成员不是一个常量成员
 * 5. 。。。
 *
 * @author Sonic
 * @since 2019/12/22
 */
public class StaticInnerClassSingleton {

    // 基于类初始化锁，只有一个线程可以获得类对象的初始化锁，即静态内部类的初始化
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }

    private StaticInnerClassSingleton() {
    }

}
