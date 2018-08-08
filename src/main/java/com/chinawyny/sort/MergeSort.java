package com.chinawyny.sort;


import java.util.Arrays;

public class MergeSort {

    private static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int num = array.length >> 1;
        int[] leftArr = new int[num];
        System.arraycopy(array, 0, leftArr, 0, num);
        int[] rightArr = new int[array.length - num];
        System.arraycopy(array, num, rightArr, 0, rightArr.length);
        return mergeTwoArray(mergeSort(leftArr), mergeSort(rightArr));
    }

    private static int[] mergeTwoArray(int[] leftArr, int[] rightArr) {
        int[] res = new int[leftArr.length + rightArr.length];

        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                res[k++] = leftArr[i++];
            } else {
                res[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            res[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            res[k++] = rightArr[j++];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 5, 3, 1, 4})));

    }
}
