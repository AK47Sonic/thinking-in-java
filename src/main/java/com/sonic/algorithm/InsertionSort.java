package com.sonic.algorithm;

import java.util.Arrays;

/**
 * InsertionSort
 * 是原地排序
 * 是稳定排序
 * <p>
 * 时间复杂度
 * <ol>
 * <li>最好时间复杂度：O(n)</li>
 * <li>最坏时间复杂度：O(n²)</li>
 * <li>平均时间复杂度：O(n²)</li>
 * </ol>
 *
 * @author Sonic
 * @since 2019/3/24
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, 2, 7, 6};
        int[] sortedArray = sortByInsertion(arr);

        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("sortedArray: " + Arrays.toString(sortedArray));
    }

    private static int[] sortByInsertion(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        int maxLength = copyArr.length;

        if (maxLength == 1) return copyArr;

        for (int i = 1; i < maxLength; i++) {
            int value = copyArr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (copyArr[j] > value) {
                    copyArr[j + 1] = copyArr[j];
                } else {
                    break;
                }
            }
            copyArr[j + 1] = value;
        }
        return copyArr;
    }

}
