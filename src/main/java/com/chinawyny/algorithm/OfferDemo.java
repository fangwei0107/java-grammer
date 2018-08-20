package com.chinawyny.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class OfferDemo {

    private boolean find(int[][] array, int target) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int column = array[0].length - 1;
        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return true;
            }else if (array[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    private String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < str.length();i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode node) {
        if (node == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        printListFromTailToHeadHelper(node, list);
        return list;
    }

    private void printListFromTailToHeadHelper(ListNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        printListFromTailToHeadHelper(node.next, list);
        list.add(node.val);
    }

    private TreeNode reconstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || in.length == pre.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0;i < pre.length;i++) {
            if (pre[0] == in[i]) {
                root.left = reconstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i),
                        Arrays.copyOfRange(in, 0, i - 1));
                root.right = reconstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length - 1),
                        Arrays.copyOfRange(in, i + 1, in.length - 1));
            }
        }
        return root;
    }

    private Stack<Integer> stack1, stack2;

    private void push(int node) {
        stack1.push(node);
    }

    private int pop() {

        while (!stack1.isEmpty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int res = stack2.pop();

        while (!stack2.isEmpty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return res;
    }

    public long fibonacci(int n) {
        int[] array = new int[n + 1];
        fibonacciHelper(n, array);
        return array[n];
    }

    private int fibonacciHelper(int n, int[] array) {

        if (n == 0) {
            return array[0];
        }
        if (n == 1) {
            array[1] = 1;
            return array[1];
        }

        if (array[n] == 0) {
            array[n] = fibonacciHelper(n - 1, array) + fibonacciHelper(n - 2, array);
            return array[n];
        } else {
            return array[n];
        }
    }

    private int jump(int n) {
        if (n <= 2) {
            return n;
        }

        return jump(n - 1) + jump(n - 2);
    }

    private int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        OfferDemo demo = new OfferDemo();
        System.out.println(demo.fibonacci(4));
    }
}
