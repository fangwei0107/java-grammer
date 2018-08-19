package com.chinawyny.algorithm;

import java.util.ArrayList;

public class PalindromeStr {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        partitionHelper(lists, list, s);
        return lists;
    }

    private void partitionHelper(ArrayList<ArrayList<String>> lists, ArrayList<String> list, String str) {
        if (str == null || str.length() == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i <= str.length();i++) {
            String testStr = str.substring(0,i);
            if (isPalindrome(testStr)) {
                list.add(testStr);
                partitionHelper(lists, list, str.substring(i));
//                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0, j = str.length() - 1;i < j;i++,j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeStr palindromeStr = new PalindromeStr();
        System.out.println(palindromeStr.partition("aab"));
    }
}
