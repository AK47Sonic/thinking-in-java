package com.sonic.qapd;

/**
 * Loopy
 *
 * 2^31 -1 越界，变负数，i <= end 永远成立
 *
 * @author Sonic
 * @since 2019/7/14
 */
public class Loopy {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++) {
            System.out.println("i = " + i);
            count++;
        }
        System.out.println(count);
    }
}