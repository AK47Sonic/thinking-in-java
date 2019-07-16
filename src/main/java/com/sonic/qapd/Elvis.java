package com.sonic.qapd;

import java.util.Calendar;

/**
 * Elvis
 * 这道面试题是这样的：
 *
 * class SingleTon {
 * private static SingleTon singleTon = new SingleTon();
 * public static int count1;
 * public static int count2 = 1;
 *
 * private SingleTon() {
 *     count1++;
 *     count2++;
 * }
 *
 * public static SingleTon getInstance() {
 *     return singleTon;
 * }
 * }
 *
 * public class Test {
 * public static void main(String[] args) {
 * SingleTon singleTon = SingleTon.getInstance();
 * System.out.println("count1=" + singleTon.count1);
 * System.out.println("count2=" + singleTon.count2);
 * }
 * }
 *
 * 这道题目的答案是： singTon.count1=1 singTon.count2=1， 而不是count1=1 和 count2=2
 *
 * 原因分析：
 *
 * 1. 首先静态字段会进行默认顺序初始化。即 singTon=null count1=0 count2=0
 *
 * 2. 然后静态字段会进行显示初始化。问题就出现这里(这里就是影响结果的地方)
 *
 * 3. 首先 singTon 进行显示初始化 它会创建 实例，调用构造函数,执行完成以后 此时 count1=1 count2=1
 *
 * 然后才是静态变量 count1和count2进行显示初始化，因为count1没有显示初始化值，所以结果就是 count1=1 但是 count2变量进行完显示初始化后值就为 1了 (在此过程之前静态变量count1和count2还没有进行显示初始化的)
 * 所以，综上 结果是 singTon.count1=1 singTon.count2=1
 *
 * 衍生到昨天那道题目：
 *
 * public class Elvis {
 *
 * public static final Elvis ELVIS = new Elvis();
 *
 * private Elvis() {
 * }
 *
 * private static final Boolean LIVING = true;
 *
 * private final Boolean alive = LIVING;
 *
 * public final Boolean lives() {
 *     return alive;
 * }
 *
 * public static void main(String[] args) {
 *     System.out.println(ELVIS.lives() ? "Hound Dog" : "Heartbreak Hotel");
 * }
 * }
 *
 * 分析：
 *
 * 首先静态字段会进行默认顺序初始化: ELVIS = null, LIVING = null
 * 然后静态字段会进行显示初始化, Elvis ELVIS = new Elvis(); -> alive = LIVING;
 * 此时的LIVING还是null， 所以alive 也是null
 * 进行LIVING 的显式初始化， LIVING = true
 * 因此ELVIS.lives() 是null
 * 所以，我觉得以上2道面试题基本类似，是因为静态字段在顺序初始化时候分为默认赋值和显式赋值两个阶段，导致了以上的问题。
 *
 * @author Sonic
 * @since 2019/7/16
 */
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;

    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);

    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears size " +
                INSTANCE.beltSize() + " belt.");
    }
}