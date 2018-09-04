package com.chinawyny.algorithm.dp;

import java.util.*;

public class DpDemo {

    private static int dp1(int[][] arr) {

        int length = arr.length;

        int[][] res = new int[length][length];

        int max = Integer.MIN_VALUE;

        res[0][0] = arr[0][0];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    res[i][j] = res[i - 1][j] + arr[i][j];
                } else if (i == j) {
                    res[i][j] = res[i - 1][j - 1] + arr[i][j];
                } else {
                    res[i][j] = Math.max(res[i - 1][j - 1], res[i - 1][j]) + arr[i][j];
                }
                if (res[i][j] > max) {
                    max = res[i][j];
                }
            }
        }
        return max;
    }

    private static int dp2(String a, String b) {

        if (a == null || b == null || a.length() < 1 || b.length() < 1) {
            throw new IllegalArgumentException();
        }

        int aLen = a.length();

        int bLen = b.length();

        int[][] dp = new int[aLen + 1][bLen + 1];

        if (a.charAt(0) != b.charAt(0)) {
            dp[0][0] = 1;
        }

        for (int i = 1; i < aLen; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int j = 1; j < bLen; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }


        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[aLen - 1][bLen - 1];

    }

    private static int dp3(int[][] a) {

        int len = a.length;
        int[][] dp = new int[len][len];

        dp[0][0] = a[0][0];

        for (int i = 1; i < len; i++) {
            dp[0][i] = dp[0][i - 1] + a[0][i];
            dp[i][0] = dp[i - 1][0] + a[i][0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + a[i][j];
            }
        }

        return dp[len - 1][len - 1];

    }

    private static int packageDemo(int[] values, int[] weight, int maxContain) {

        int len = values.length;
        int[][] dp = new int[len][maxContain + 1];

        for (int i = 1; i < maxContain + 1; i++) {

            if (i >= weight[0]) {
                dp[0][i] = values[0];
            }

        }

        for (int i = 1; i < len; i++) {

            for (int v = maxContain; v > 0; v--) {
                if (v > weight[i]) {
                    dp[i][v] = Math.max(dp[i - 1][v - weight[i]] + values[i], dp[i - 1][v]);
                } else {
                    dp[i][v] = dp[i - 1][v];
                }
            }

        }
        return dp[len - 1][maxContain];
    }

    private static int packageDemo2(int[] values, int[] weight, int maxContain) {

        int len = values.length;
        int[] dp = new int[maxContain + 1];

        for (int i = 1; i < maxContain + 1; i++) {

            if (i >= weight[0]) {
                dp[i] = values[0];
            }

        }

        for (int i = 1; i < len; i++) {

            for (int v = maxContain; v > 0; v--) {
                if (v > weight[i]) {
                    dp[v] = Math.max(dp[v - weight[i]] + values[i], dp[v]);
                }
            }

        }
        return dp[maxContain];
    }

    private static List<String> permutation(char[] chars) {

        List<String> res = new ArrayList<String>();

        permutation(chars, 0, res);

        return res;
    }

    private static void permutation(char[] chars, int start, List<String> res) {

        if (start >= chars.length - 1) {
            res.add(new String(chars));
            return;
        } else {
            char temp;

            for (int i = start; i < chars.length; i++) {

                temp = chars[i];
                chars[i] = chars[start];
                chars[start] = temp;
                permutation(chars, i + 1, res);
                temp = chars[i];
                chars[i] = chars[start];
                chars[start] = temp;
            }
        }

    }


    private static List<String> combine(char[] chars) {

        List<String> res = new ArrayList<String>();

        List<Character> temp = new ArrayList<>();

        for (int i = 1; i <= chars.length; i++) {
            combine(chars, 0, i, temp, res);

        }

        return res;
    }

    private static void combine(char[] chars, int start, int len, List<Character> temp, List<String> res) {

        if (len <= 0) {

            char[] tempArr = new char[temp.size()];
            int i = 0;
            for (char c : temp) {
                tempArr[i] = c;
                i++;
            }

            res.add(new String(tempArr));
            return;
        }

        if (start < chars.length) {
            temp.add(chars[start]);
            combine(chars, start + 1, len - 1, temp, res);
            temp.remove(temp.size() - 1);
            combine(chars, start + 1, len, temp, res);
        }

    }

    public static void main(String[] args) {
        List<String> res = combine(new char[]{'a', 'b', 'c'});

        for (String a : res.toArray(new String[res.size()])) {
            System.out.print(a + " ");
        }
    }
}
