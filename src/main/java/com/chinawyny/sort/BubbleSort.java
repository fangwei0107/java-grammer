package com.chinawyny.sort;

import java.util.Arrays;

public class BubbleSort {

    private static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i && j + 1 < i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }

    private static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int l = low;
        int r = high;
        int privot = array[l];
        while (l < r) {
            while (array[r] >= privot && l < r) {
                r--;
            }
            array[l] = array[r];
            while (array[l] <= privot && l < r) {
                l++;
            }
            array[r] = array[l];
        }
        array[l] = privot;
        quickSort(array, low, l - 1);
        quickSort(array, l + 1, high);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{1, 5, 4, 2, 3})));
    }
}
