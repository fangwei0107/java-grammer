package com.chinawyny.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class SingNum {
    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1;i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int res = candies[ratings.length - 1];

        for (int i = ratings.length - 2;i>=0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
            res += candies[i];
        }

        return res ;

    }


    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,5}));
    }
}
