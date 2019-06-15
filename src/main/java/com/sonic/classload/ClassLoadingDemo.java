package com.sonic.classload;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * ClassLoadingDemo
 *
 * @author Sonic
 * @since 2019/6/14
 */
public class ClassLoadingDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println(System.getProperty("user.home"));

        String className = "com.sonic.classload.User";
        String classFileName = className.replace(".", "/").concat(".class");
        String classPath = System.getProperty("user.dir") + "/target/classes/";
        File classFile = new File(classPath, classFileName);
        System.out.println("ClassPath: " + classFile.getAbsolutePath());

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> userClass = myClassLoader.defineClass(className, classFile);

        System.out.println("MyClassLoader userClass: " + userClass.hashCode());

        Stream.of(userClass.getDeclaredFields()).forEach(field -> {
            System.out.println("MyClassLoader userClass field: " + field);
        });

        Class<?> userClassFromThreadContextClassLoader = contextClassLoader.loadClass(className);
        System.out.println("userClass FromThreadContextClassLoader: " + userClassFromThreadContextClassLoader.hashCode());
        System.out.println(userClass == userClassFromThreadContextClassLoader);

        // 重新替换掉上线文 ClassLoader

        Thread.currentThread().setContextClassLoader(myClassLoader);
        ClassLoader contextClassLoaderMyClassLoader = Thread.currentThread().getContextClassLoader();

        Class<?> userClassFromMyClassLoader = contextClassLoaderMyClassLoader.loadClass(className);
        System.out.println(userClassFromMyClassLoader);
        System.out.println(userClass == userClassFromMyClassLoader);

        System.out.println(userClassFromThreadContextClassLoader == userClassFromMyClassLoader);


    }

    static class MyClassLoader extends ClassLoader {
        public MyClassLoader() {
            // App ClassLoader
            super(Thread.currentThread().getContextClassLoader());
        }

        public Class<?> defineClass(String name, File classFile) {

            byte[] bytes = loadBytes(classFile);
            return super.defineClass(name, bytes, 0, bytes.length);
        }

        private byte[] loadBytes(File classFile) {
            byte[] bytes = null;
            try {
                bytes = FileUtils.readFileToByteArray(classFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return bytes;
        }

    }

}
