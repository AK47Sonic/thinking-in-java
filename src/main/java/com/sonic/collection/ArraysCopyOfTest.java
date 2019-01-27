package com.sonic.collection;

import java.util.Arrays;

/**
 * ArraysCopyOfTest
 *
 * @author Administrator
 * @since 2019/1/27
 */
public class ArraysCopyOfTest {

    public static void main(String[] args) {
        String[] strArr = new String[]{"1", "2", "3"};
        String[] newStrArr = Arrays.copyOf(strArr, strArr.length+5);
        System.out.println(strArr == newStrArr);
        System.out.println("newStrArr: " + newStrArr.length);
        for (String s : newStrArr) {
            System.out.println("s: " + s);
        }
    }
}
