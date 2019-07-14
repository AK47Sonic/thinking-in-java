package com.sonic.qapd;

/**
 * Confusing
 *
 * most specific 原则，选择更加具体的类型
 *
 * @author Sonic
 * @since 2019/7/14
 */
public class Confusing {
    public Confusing(Object o) {
        System.out.println("Object");
    }

//    public Confusing(double[] dArray) {
//        System.out.println("double array");
//    }

    public Confusing(Integer i) {
        System.out.println("Integer");
    }

    public static void main(String args[]) {
        new Confusing(null);
    }
}
