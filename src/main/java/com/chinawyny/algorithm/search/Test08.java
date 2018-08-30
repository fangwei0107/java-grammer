package com.chinawyny.algorithm.search;

public class Test08 {

    private static int searchMin(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return a[0];
        }

        int left = 0;
        int right = a.length - 1;
        if (a[left] < a[right]) {
            return a[left];
        }
        while (left < right) {
            if (right - left == 1) {
                return Math.min(a[left], a[right]);
            }
            int mid = (left + right) / 2;
            if (a[left] < a[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return a[left];
    }

    private static boolean search2N(int n) {

        return (n & (n-1)) == 0;

    }

    private static int searchChangeN(int m, int n) {

        int x = m ^ n;

        int count = 0;
        while (x > 0) {
            x = x & (x - 1);
            count++;
        }

        return count;


    }

    public static void main(String[] args) {
        System.out.println(search2N(31));
        System.out.println(searchChangeN(10, 13));
    }
}
