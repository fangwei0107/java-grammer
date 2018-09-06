package com.chinawyny.algorithm.tree;

public class Offer31 {
    
    /**
     * 31. 求最大连续子数组
     *
     * @param arr
     * @return
     */
    private static int maxSeq(int[] arr) {
        
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException();
        }
        
        int max = Integer.MIN_VALUE;
        int curMax = 0;
    
        for (int x : arr) {
        
            if (curMax <= 0) {
                curMax = x;
            } else {
                curMax += x;
            }
            if (curMax > max) {
                max = curMax;
            }
        
        }
        return max;
    }
    
    private static int minPernum(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new IllegalArgumentException();
        }
        int[] res = new int[1];
        StringBuilder str = new StringBuilder();
        for (int i = 0;i < arr.length;i++) {
            str.append(Integer.toString(arr[i]));
        }
        res[0] = Integer.valueOf(str.toString());
        int start = 0;
        minPernum(arr, res, start);
        
        return res[0];
    }
    
    private static void minPernum(int[] arr, int[] res, int start) {
        
        if (start == arr.length - 1) {
            StringBuilder str = new StringBuilder();
            for (int i = 0;i < arr.length;i++) {
                str.append(Integer.toString(arr[i]));
            }
            
            if (Integer.valueOf(str.toString()) < res[0]) {
                res[0] = Integer.valueOf(str.toString());
            }
        }
        
        
        int temp;
        for (int i = start;i < arr.length;i++) {
            
            temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
            
            minPernum(arr, res, start + 1);
    
            temp = arr[i];
            arr[i] = arr[start];
            arr[start] = temp;
        }
        
    }
    
    private static int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        
       while (nextUglyIndex < index) {
           int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5);
           uglyNumbers[nextUglyIndex] = min;
           
           while (uglyNumbers[p2] * 2 <= min) {
               p2++;
           }
           while (uglyNumbers[p3] * 3 <= min) {
               p3++;
           }
           while (uglyNumbers[p5] * 5 <= min) {
               p5++;
           }
           
           nextUglyIndex++;
           
       }
        
        return uglyNumbers[index - 1];
        
    }
    
    private static int min(int a, int b, int c) {
        int min = a < b ? a : b;
        return min < c ? min : c;
    }
    
    
    
    public static void main(String[] args) {
        int[] data = {3, 5, 1, 4, 2};
        System.out.println(minPernum(data));
    }
    
}
