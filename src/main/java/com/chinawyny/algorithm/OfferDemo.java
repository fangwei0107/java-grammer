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

    private static double power(double base, int e) {
        if (e == 0) {
            return 1;
        }

        int exp = e;
        if (e < 0) {
            exp = -e;
        }

        double res = powerHelp(base, exp);

        if (e < 0) {
            res = 1 / res;
        }
        return res;
    }

    private static double powerHelp(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        if (exp == 1) {
            return base;
        }

        double res = powerHelp(base, exp >> 1);

        res *= res;

        if ((exp & 0x1) == 1) {
            res *= base;
        }
        return res;
    }

    private static void printDigits(int n) {
        if (n < 1) {
            return;
        }

        int[] arr = new int[n];
        printDigits2(0, arr);
    }

    private static void printDigits(int n, int[] arr) {

        for(int i = 0; i < 10; i++) {
            if(n != arr.length) {
                arr[n] = i;
                printDigits(n+1, arr);
            } else {
                boolean isFirstNo0 = false;
                for (int x : arr) {
                    if (x != 0) {
                        System.out.print(x);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if (isFirstNo0)
                            System.out.print(x);
                    }
                }
                System.out.println();
                return ;
            }
        }

    }

    private static void printDigits2(int n, int[] arr) {
        for (int i = 0;i < 10; i++) {
            if (n != arr.length) {
                arr[n] = i;
                printDigits2(n + 1, arr);
            } else {
                boolean isFirst0 = false;
                for(int x : arr) {
                    if (x !=0) {
                        System.out.print(x);
                        isFirst0 = true;
                    } else {
                        if (isFirst0) {
                            System.out.print(0);
                        }
                    }
                }
                System.out.println();
                return;
            }

        }
    }

    private static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int left = 0;

        int right = arr.length - 1;

        while (left < right) {
            while (left < right && (arr[left] & 1) == 1) {
                left++;
            }

            while (left < right && (arr[right] & 1) != 1) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

        }
    }


    private static ListNode lastNPoint(ListNode root, int n) {
        if (root == null || n <= 0) {
            return null;
        }
        ListNode temp = root;
        int i = 1;
        for (;i < n; i++) {
            if (temp == null) {
                return null;
            } else {
                temp = temp.next;
            }
        }

        if (i != n || temp == null) {
            return null;
        }
        ListNode res = root;
        while (temp.next != null) {
            temp = temp.next;
            res = res.next;
        }

        return res;

    }

    private static ListNode midNode(ListNode root) {

        if (root == null || root.next == null) {
            return root;
        }

        ListNode fast = new ListNode(0);
        fast.next = root;
        ListNode slow = new ListNode(0);
        slow.next = root;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode pre = root;
        ListNode mid = root.next;
        ListNode next = mid.next;
        pre.next = null;

        while (next != null) {
            mid.next = pre;

            pre = mid;
            mid = next;
            next = next.next;
        }
        mid.next = pre;
        return mid;

    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode res = new ListNode(0);

        ListNode temp1= l1;
        ListNode temp2 = l2;
        ListNode work = res;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                work.next = temp1;
                temp1 = temp1.next;
            } else {
                work.next = temp2;
                temp2 = temp2.next;
            }
            work = work.next;
        }

        if (temp1 != null) {
            work.next = temp1;
        }
        if (temp2 != null) {
            work.next = temp2;
        }

        return res.next;
    }

    private static void printList(ListNode root) {

        if (root == null) {
            return;
        }

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n3.next = n4;

        ListNode res = merge(n1,n3);
        printList(res);

    }
}




























