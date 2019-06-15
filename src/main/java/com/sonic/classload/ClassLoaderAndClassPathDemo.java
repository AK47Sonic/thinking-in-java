package com.sonic.classload;

/**
 * ClassLoaderAndClassPathDemo
 *
 * @author Sonic
 * @since 2019/6/15
 */
public class ClassLoaderAndClassPathDemo {
    public static void main(String[] args) {
        // Bootstrap classLoader加载class会抛出null
//        getClassLocation(Object.class);
//        getClassLocation(int.class);
        getClassLocation(ClassLoaderAndClassPathDemo.class);
    }

    private static void getClassLocation(Class<?> klass) {
        System.out.printf("Class[%s] location: %s\n", klass, klass.getProtectionDomain().getCodeSource().getLocation());
    }
}
