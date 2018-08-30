package com.chinawyny.algorithm.tree;

import com.chinawyny.algorithm.TreeNode;

import java.util.LinkedList;

public class LevelTravel {

    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = run(root.left);
        int r = run(root.right);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }

        return Math.min(l, r) + 1;
    }

    public int run1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 1, start = 0, end = 1;
        while (!queue.isEmpty()) {
            start++;
            TreeNode node = queue.removeFirst();
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
            if (start == end) {
                end = queue.size();
                start = 0;
                level++;
            }
        }
        return level;
    }
}
