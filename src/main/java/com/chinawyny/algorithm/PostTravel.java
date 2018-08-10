package com.chinawyny.algorithm;

import java.util.ArrayList;

public class PostTravel {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postTravel(root,list);
        return list;

    }

    public void postTravel(TreeNode root, ArrayList<Integer> list) {
        list.add(root.val);

        if (root.left != null) {
            postTravel(root.left, list);
        }

        if (root.right != null) {
            postTravel(root.right, list);
        }

    }
}
