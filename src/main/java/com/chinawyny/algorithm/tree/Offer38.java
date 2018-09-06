package com.chinawyny.algorithm.tree;

import com.chinawyny.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer38 {


    private static int getFirstK(int[] data, int k, int start, int end) {

        if (start > end || data == null || data.length < 1) {
            return -1;
        }

        int midIndex = start + ((end - start) >> 2);

        int midData = data[midIndex];
        if (k == midData) {
            if (midIndex > 0 && data[midIndex - 1] != k || midIndex == 0) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if(midData > k) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }

        return getFirstK(data, k, start, end);
    }

    private static int getLastK(int[] data, int k, int start, int end) {

        if (start > end || data == null || data.length < 1) {
            return -1;
        }

        int midIndex = start + ((end - start) >> 2);

        int midData = data[midIndex];
        if (k == midData) {

            if (midIndex < data.length - 1 && data[midIndex + 1] != k || midIndex == data.length - 1) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }

        } else if (midData > k){
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return getLastK(data, k, start, end);
    }

    private static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if (data != null && data.length > 0) {
            int first = getFirstK(data, k, 0, data.length - 1);
            int last = getLastK(data, k, 0, data.length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
    }

    private static int maxLevel(TreeNode root) {

        if (root == null) {
            return -1;
        }

        LinkedList<TreeNode> l = new LinkedList<>();
        l.add(root);

        int curSize = 1;

        int level = 1;
        while (!l.isEmpty()) {
            TreeNode node = l.removeFirst();
            curSize--;
            if (node.left != null) {
                l.add(node.left);
            }

            if (node.right != null) {
                l.add(node.right);
            }

            if (curSize == 0 && !l.isEmpty()) {
                level++;
                curSize = l.size();
            }
        }

        return level;

    }

    private static int maxLevel2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = maxLevel2(root.left);

        int r = maxLevel2(root.right);

        return l > r ? (l + 1) : (r + 1);
    }

    private static boolean isBalancedTree(TreeNode root) {

        if(root == null) {
            return true;
        }

        int l = maxLevel2(root.left);

        int r = maxLevel2(root.right);

        int diff = l - r;

        if (diff > 1 || diff < -1) {
            return false;
        }

        return isBalancedTree(root.left) && isBalancedTree(root.right);

    }

    private static boolean isBalanced2(TreeNode root) {

        int[] depth = new int[1];

        return isBalanced2(root, depth);


    }

    private static boolean isBalanced2(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;

            return true;
        }

        int[] l = new int[1];

        int[] r = new int[1];

        if (isBalanced2(root.left, l) && isBalanced2(root.right, r)) {
            int diff = l[0] - r[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = l[0] > r[0] ? l[0] + 1 : r[0] + 1;
                return true;
            }
        }

        return false;
    }

    private static int[] find2Single(int[] data) {


        int[] res = new int[2];
        int temp = data[0];
        for (int i = 1;i <data.length;i++) {
            temp = temp ^ data[i];
        }

        int indexOf1 = 1;

        while ((temp & 1) != 1) {
            indexOf1 = indexOf1 * 2;
            temp = temp >> 1;
        }

        List<Integer> l1 = new ArrayList<>();

        List<Integer> l2 = new ArrayList<>();

        for (int x : data) {
            if ((x & indexOf1) != 0) {
                l1.add(x);
            } else {
                l2.add(x);
            }
        }

        temp = l1.get(0);

        for (int i = 1;i < l1.size();i++) {
            temp = temp ^ l1.get(i);
        }

        res[0] = temp;

        temp = l2.get(0);
        for (int i = 1;i < l2.size();i++) {
            temp = temp ^ l2.get(i);
        }

        res[1] = temp;


        return res;
    }

    private static int[] findNumbersWithSum(int[] data, int targetSum) {

        int[] res = new int[2];

        int head = 0;

        int tail = data.length - 1;

        int curSum = 0;

        while (head < tail) {

            curSum = data[head] + data[tail];

            if (curSum > targetSum) {
                tail--;
            } else if (curSum < targetSum) {
                head++;
            } else {
                res[0] = data[head];
                res[1] = data[tail];
                break;
            }

        }

        return res;
    }

    private static List<List<Integer>> findContinuousSequence(int sum) {



        List<List<Integer>> res = new ArrayList<>();
        int small = 1;
        int big = 2;
        int end = (1 + sum) >> 2;

        int curSum = small + big;

        while (big <= end) {

            if (curSum == sum) {

                List<Integer> temp = new ArrayList<>();
                for (int i = small;i <= big;i++) {
                    temp.add(i);
                }
                res.add(temp);

            } else if(curSum < sum) {
                big++;
                curSum += big;
            } else {
                curSum -= small;
                small++;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};


        System.out.println(Arrays.toString(find2Single(data1)));
    }

}
