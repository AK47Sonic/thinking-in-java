package com.sonic.basic;

/**
 * ClassConverter
 *
 * @author Sonic
 * @since 2019/8/24
 */
public class ClassConverter {

    public static void main(String[] args) {
        Number number = Integer.valueOf(10);
        Integer intNum = (Integer) number;
        Integer castInt = Integer.class.cast(number);
        System.out.println("intNum: " + intNum);
        System.out.println("castInt: " + castInt);

    }

}
