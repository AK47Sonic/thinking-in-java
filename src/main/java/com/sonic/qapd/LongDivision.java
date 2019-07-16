package com.sonic.qapd;

/**
 * LongDivision
 *
 * 和越界有关系，没有申明为l 或者L，默认是int，越界了，所以不是1000了
 * 因为MICRO_PER_DAY右边先是int类型算出来的二进制是1010000011101110101110110000000000000, 已经溢出了,
 * 抛弃高位截取底32位是00011101110101110110000000000000, 转换成十进制是500654080,
 * 所以是5... 如果 MICROS_PER_DAY = 24 60 60 1000 1000L 的话选B
 *
 * @author Sonic
 * @since 2019/7/16
 */
public class LongDivision {

    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;

    private static final long MICROS_PER_DAY
            = 24 * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}