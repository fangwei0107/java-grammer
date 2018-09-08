package com.chinawyny.algorithm.tree;

import com.chinawyny.algorithm.TreeNode;

public class SelfDemo {
    
    private static int maxLevel(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int l = maxLevel(root.left);
        
        int r = maxLevel(root.right);
        
        return (l > r ? l : r) + 1;
        
    }
    
    private static boolean isBalanced(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        int l = maxLevel(root.left);
        
        int r = maxLevel(root.right);
        
        int diff = l- r;
        
        if (diff < -1 || diff > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    private static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int[] level = new int[1];
        return isBalanced2(root, level);
        
    }
    
    private static boolean isBalanced2(TreeNode root, int[] level) {
        
        if (root == null) {
            level[0] = 0;
            return true;
        }
        
        int[] l = new int[1];
        int[] r = new int[1];
        
        if (isBalanced2(root.left, l) && isBalanced2(root.right, r)) {
            level[0] = l[0] > r[0] ? l[0] + 1 : r[0] + 1;
            int diff = l[0] - r[0];
            return diff >= -1 && diff <= 1;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        n1.left = n2;
        n2.left = n3;
    
        System.out.println(isBalanced2(n1));
        
    }
}
