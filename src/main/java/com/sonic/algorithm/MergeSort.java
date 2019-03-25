package com.sonic.algorithm;

import java.util.Arrays;

/**
 * MergeSort
 *
 * @author Sonic
 * @since 2019/3/25
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 1, 2, 7, 6};
        split(arr, 0, arr.length - 1);
        System.out.println("sortedArray: " + Arrays.toString(arr));
    }

    private static void split(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) >> 1;
            split(arr, left, middle);
            split(arr, middle + 1, right);
            mergeAndSort(arr, left, middle, right);
        }
    }

    private static void mergeAndSort(int[] arr, int left, int middle, int right) {

        int[] tempArr = new int[right - left + 1];
        int leftHead = left;
        int rightHead = middle + 1;
        int tempHead = 0;

        while (leftHead <= middle && rightHead <= right) {
            if (arr[leftHead] < arr[rightHead]) {
                tempArr[tempHead++] = arr[leftHead++];
            } else {
                tempArr[tempHead++] = arr[rightHead++];
            }
        }

        while (leftHead <= middle) {
            tempArr[tempHead++] = arr[leftHead++];
        }

        while (rightHead <= right) {
            tempArr[tempHead++] = arr[rightHead++];
        }

        leftHead = left;
        tempHead = 0;

        while (leftHead <= right) {
            arr[leftHead++] = tempArr[tempHead++];
        }

    }

}
