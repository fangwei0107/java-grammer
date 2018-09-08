package com.chinawyny.algorithm.tree;

import com.chinawyny.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer38 {
    
    
    private static int getFirstK(int[] data, int k, int start, int end) {
        
        if (start > end || data == null || data.length < 1) {
            return -1;
        }
        
        int midIndex = start + ((end - start) >> 1);
        
        int midData = data[midIndex];
        if (k == midData) {
            if (midIndex > 0 && data[midIndex - 1] != k || midIndex == 0) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (midData > k) {
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
        
        int midIndex = start + ((end - start) >> 1);
        
        int midData = data[midIndex];
        if (k == midData) {
            
            if (midIndex < data.length - 1 && data[midIndex + 1] != k || midIndex == data.length - 1) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }
            
        } else if (midData > k) {
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
        
        if (root == null) {
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
        for (int i = 1; i < data.length; i++) {
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
        
        for (int i = 1; i < l1.size(); i++) {
            temp = temp ^ l1.get(i);
        }
        
        res[0] = temp;
        
        temp = l2.get(0);
        for (int i = 1; i < l2.size(); i++) {
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
        int end = (1 + sum) >> 1;
        
        int curSum = small + big;
        
        while (big <= end) {
            
            if (curSum == sum) {
                
                List<Integer> temp = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    temp.add(i);
                }
                res.add(temp);
                
            }
            while (curSum > sum && small < end) {
                curSum -= small;
                small++;
            }
            big++;
            curSum += big;
            
        }
        return res;
    }
    
    private static String reverseWord(String line) {
        
        char[] chars = line.toCharArray();
        int start = 0;
        
        int end = chars.length - 1;
        
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            
            start++;
            end--;
        }
        
        String revers = new String(chars);
        
        String[] strings = revers.split(" ");
        
        StringBuilder res = new StringBuilder();
        
        for (String str : strings) {
            
            char[] charArr = str.toCharArray();
            start = 0;
            end = charArr.length - 1;
            while (start < end) {
                temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
        
                start++;
                end--;
            }
            
            res.append(charArr);
        }
        
        return res.toString();
    }
    
    private static String rotate(char[] chars, int n) {
        
        if (chars == null || chars.length < n) {
            throw new IllegalArgumentException("");
        }
        int start = 0;
    
        int end = chars.length - 1;
    
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        
            start++;
            end--;
        }
        
        start = 0;
        end = chars.length - n - 1;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
    
            start++;
            end--;
        }
        
        start = chars.length - n;
        end = chars.length - 1;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
    
            start++;
            end--;
        }
        
        return new String(chars);
    }
    
    private static double[] probability(int num, int max) {
    
        if (num < 1 || max < 1) {
            return null;
        }
        
        int maxSum = num * max;
        
        int[] probabilities = new int[maxSum - num + 1];
        
        double total = 1;
        for (int i = 0;i < num;i++) {
            total *= max;
        }
        
        probability(num, max, probabilities);
    
        double[] res = new double[maxSum - num + 1];
        for (int i = num;i <= maxSum;i++) {
            double ratio = probabilities[i - num] / total;
            res[i - num] = ratio;
        }
        
        return res;
    
    }
    
    private static void probability(int num, int max, int[] probabilities) {
        
        for (int i = 1;i <= max;i++) {
            probability(num, num - 1, i, probabilities, max);
        }
    
    }
    
    private static void probability(int num, int current, int curSum, int[] probabilities, int max) {
        
        if (current == 0) {
            probabilities[curSum - num]++;
        } else {
            for (int i = 1;i <= max;i++) {
                probability(num, current - 1, curSum + i, probabilities, max);
            }
        }
    
    }
    
    private static double[] probability2(int num, int max) {
        
        if (num < 1 || max < 1) {
            return null;
        }
        
        int[][] probablities = new int[2][num * max + 1];
        
        for (int i = 0;i < max * num + 1;i++) {
            probablities[0][i] = 0;
            probablities[1][i] = 0;
        }
        
        boolean flag = true;
        
        for (int i = 1;i <= max;i++) {
            probablities[flag ? 1 : 0][i] = 1;
        }
        
        for (int k = 2;k <= num;k++) {
            
            for (int i = 0;i < k;i++) {
                flag = !flag;
                probablities[flag ? 1 : 0][i] = 0;
            }
            
            for (int i = k;i <= max * k;i++) {
                probablities[flag ? 1 : 0][i] = 0;
                for (int j = 1; j <= i && j <= max; j++) {
                    // 统计出和为i的点数出现的次数
                    probablities[flag ? 1 : 0][i] += probablities[flag ? 1 : 0][i - j];
                }
            }
            
        }
        
        return null;
        
    }
    
    private static int lastRemainning(int n, int m) {
    
        if (n < 1 || m < 1) {
            return -1;
        }
        
        LinkedList<Integer> circle = new LinkedList<>();
        
        for (int i = 0;i < n;i++) {
            circle.addLast(i);
        }
        
        int idx = 0;
        int start = 0;
        
        while (circle.size() > 1) {
            idx = (start + m - 1) % circle.size();
            circle.remove(idx);
            idx %= circle.size();
            start = idx;
        }
        
        return circle.get(0);
    }
    
    public static void main(String[] args) {
        int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
        
        
        System.out.println(lastRemainning(5, 2));
    }
    
}
