package com.chinawyny.algorithm;

public class Test47 {
    
    private static int add(int x, int y) {
        int sum = 0;
        int carry = 0;
        
        do {
            sum = x ^ y;
            
            carry = (x & y) << 1;
            
            x = sum;
            y = carry;
        } while (y != 0);
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(add(1, 2) + ", " + (1 + 2));
    }
}
