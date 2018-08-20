package com.chinawyny.algorithm;

public class RunntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new String("计算机" + "软件");
        System.out.println(str1.intern() == str1);

        String str2 = new String("ja" + "va");
        System.out.println(str2.intern() == str2);
    }
}
