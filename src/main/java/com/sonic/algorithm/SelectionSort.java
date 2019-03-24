package com.sonic.algorithm;

import java.util.Arrays;

/**
 * SelectionSort
 * 是原地排序
 * 不是稳定排序
 * <p>
 * 时间复杂度
 * <ol>
 * <li>最好时间复杂度：O(n²)</li>
 * <li>最坏时间复杂度：O(n²)</li>
 * <li>平均时间复杂度：O(n²)</li>
 * </ol>
 *
 * @author Sonic
 * @since 2019/3/24
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 3, 1, 2, 7, 6};
        int[] sortedArray = sortBySelection(arr);

        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("sortedArray: " + Arrays.toString(sortedArray));

    }

    private static int[] sortBySelection(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        int maxLength = copyArr.length;

        if (maxLength == 1) return copyArr;

        for (int i = 0; i < maxLength; i++) {
            int minIndex = i;
            for (int j = i + 1; j < maxLength; j++) {
                if (copyArr[j] < copyArr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = copyArr[i];
            copyArr[i] = copyArr[minIndex];
            copyArr[minIndex] = temp;
        }

        return copyArr;
    }

}
