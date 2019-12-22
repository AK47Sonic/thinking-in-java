package com.sonic.gof23.singleton;

/**
 * LazySingleton
 *
 * @author Sonic
 * @since 2019/12/22
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

//    public static LazySingleton getInstance() {
////        synchronized (LazySingleton.class) {
////            if (lazySingleton == null) {
////                lazySingleton = new LazySingleton();
////            }
////        }
////        return lazySingleton;
////    }

    public synchronized static LazySingleton getInstance() {
            if (lazySingleton == null) {
                lazySingleton = new LazySingleton();
            }
        return lazySingleton;
    }

}
