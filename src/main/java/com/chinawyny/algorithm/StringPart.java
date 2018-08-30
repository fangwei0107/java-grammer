package com.chinawyny.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPart {

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Arrays.sort(num);

        int length = 1;
        int  maxLength = 1;
        for (int i = 0;i < num.length - 1; i++) {
            int sub = num[i + 1] - num[i];
            if (sub == 0) {
                continue;
            }
            if (sub == 1) {
                length++;

            } else {
                if (maxLength < length) {
                    maxLength = length;
                }
                length = 1;
            }
        }
        if (maxLength < length) {
            maxLength = length;
        }

        return maxLength;

    }

    public static void main(String[] args) {
        StringPart stringPart = new StringPart();
        System.out.println(stringPart.longestConsecutive(new int[] {9,1,4,7,3,-1,0,5,8,-1,6}));
    }
}
