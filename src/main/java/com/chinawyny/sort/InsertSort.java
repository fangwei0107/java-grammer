package com.chinawyny.sort;

import java.util.Arrays;

public class InsertSort {

    private static int[] insertSort(int[] array) {

        int length = array.length;
        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];

            }
            array[j + 1] = temp;
        }
        return array;
    }

    private static int[] shellSort(int[] array) {

        int length = array.length;

        for (int step = length / 2; step > 0;step /= 2) {
            for (int i = step;i < length;i += step) {
                int j = i - step;
                int temp = array[i];
                for (;j >= 0 && temp < array[j];j -= step) {
                    array[j + step] = array[j];
                }
                array[j + step] = temp;
            }
        }

        return array;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertSort(new int[]{2, 5, 3, 1, 4})));
        System.out.println(Arrays.toString(shellSort(new int[]{2, 5, 3, 1, 4})));

    }


}
