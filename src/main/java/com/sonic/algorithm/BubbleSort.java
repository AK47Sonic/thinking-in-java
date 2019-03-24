package com.sonic.algorithm;

import java.util.Arrays;

/**
 * BubbleSort
 * 是原地排序
 * 是稳定排序
 * <p>
 * 时间复杂度
 * <ol>
 *     <li>最好时间复杂度：O(n)</li>
 *     <li>最坏时间复杂度：O(n²)</li>
 *     <li>平均时间复杂度：O(n²)</li>
 * </ol>
 *
 * @author Sonic
 * @since 2019/3/24
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 3, 1, 2, 7, 6};
        int[] sortedArray = sortByBubble(arr);

        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("sortedArray: " + Arrays.toString(sortedArray));

    }

    private static int[] sortByBubble(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        int maxLength = copyArr.length;

        //如果只有一个元素直接返回
        if(maxLength == 1) return copyArr;

        //如果大于一个元素，进行两两比较
        for (int i = 0; i < maxLength; i++) {
            boolean sortedFlag = true;
            //每一轮比较会决定一个值
            for (int j = 0; j < maxLength - i - 1; j++) {
                if (copyArr[j] > copyArr[j + 1]) {
                    int temp = copyArr[j + 1];
                    copyArr[j + 1] = copyArr[j];
                    copyArr[j] = temp;
                    sortedFlag = false;
                }
            }
            //如果一轮比较后，没有发生过交换操作，说明已经有序
            if (sortedFlag == true) {
                break;
            }

        }
        return copyArr;
    }

}
