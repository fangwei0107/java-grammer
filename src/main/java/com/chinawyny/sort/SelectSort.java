package com.chinawyny.sort;

import java.util.Arrays;

public class SelectSort {

    private static int[] selectSort(int[] array) {
        int length = array.length;
        for (int i = 0;i < length - 1;i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1;j < length;j++) {
                if (min > array[j]) {
                    minIndex = j;
                    min = array[j];
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }


    private static int[] heapSort(int[] array) {
        for (int i = 0;i < array.length;i++) {
            buildHeap(array, array.length - i);
            int temp = array[0];
            array[0] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    private static void buildHeap(int[] array, int length) {
        for (int i = (length - 1) / 2;i >= 0; i--) {
            int leftChild = 2 * i + 1;
            if (leftChild >= length) {
                continue;
            }
            int rightChild = (2 * i + 2) > length - 1 ? leftChild : (2 * i + 2);
            int biggerIndex = array[leftChild] > array[rightChild] ? leftChild : rightChild;
            if (array[biggerIndex] > array[i]) {
                int temp = array[biggerIndex];
                array[biggerIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(heapSort(new int[]{2, 5, 3, 1, 4})));
    }

}
