package com.chinawyny.algorithm;

public class Step {

    private static int run(int n, int[] arr) {
        if (arr[n] != 0) {
            return arr[n];
        }

        if (n >= 0 && n<= 2) {
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            return n;
        }

        arr[n] = run(n - 1, arr) + run(n - 2, arr);

        return arr[n];

    }

    private static int packageQues(int i, int n, int maxWeight, int[] values, int[] weights) {

        if (i == n) {
            return 0;
        }else if (maxWeight < weights[i]) {
            return packageQues(i + 1, n, maxWeight, values, weights);
        } else {
            return Math.max(packageQues(i + 1, n, maxWeight, values, weights), packageQues(i + 1, n,maxWeight - weights[i], values, weights) + values[i]);
        }

    }

    public static void main(String[] args) {
        System.out.println(run(10, new int[11]));
        System.out.println(packageQues(0, 4, 5,  new int[] {3, 2, 4, 2},new int[]{2, 1, 3, 2}));
    }


}
