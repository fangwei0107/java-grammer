package com.chinawyny.algorithm;

public class AlgorithmTest {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        node1.left = new TreeNode(1);
        node1.left.left = new TreeNode(2);
//        node1.right = new TreeNode(3);
        MinDepth2Tree minDepth2Tree = new MinDepth2Tree();
        System.out.println(minDepth2Tree.run(node1));
    }

}
