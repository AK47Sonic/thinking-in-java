package com.sonic.classload;

/**
 * ClassLoaderDemo
 *
 * @author Sonic
 * @since 2019/6/15
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println("App ClassLoader: " + ClassLoader.getSystemClassLoader()); //只读
        System.out.println(Thread.currentThread().getContextClassLoader()); // 可替换，默认AppClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader().getParent()); //ExtClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent()); //BootstrapClassLoader

        System.out.println(Object.class.getClassLoader()); // BootstrapClassLoader
        System.out.println(int.class.getClassLoader()); // BootstrapClassLoader
        System.out.println(ClassLoadingDemo.class.getClassLoader()); // 每个Class能获取到加载它的ClassLoader
        System.out.println(ClassLoadingDemo.class.getClassLoader() == ClassLoader.getSystemClassLoader());

    }

}
