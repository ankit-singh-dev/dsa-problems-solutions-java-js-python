package com.inn.trees;

/*
https://leetcode.com/problems/balanced-binary-tree/
 */

public class CheckForBalancedTree {

    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        if (height == -1) {
            return false;
        } else {
            return true;
        }

    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
