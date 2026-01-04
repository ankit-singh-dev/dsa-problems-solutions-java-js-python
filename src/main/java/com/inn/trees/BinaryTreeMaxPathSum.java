package com.inn.trees;

/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */

public class BinaryTreeMaxPathSum {

    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[]{Integer.MIN_VALUE};
        maxSum(root, maxi);
        return maxi[0];
    }

    private int maxSum(TreeNode root, int[] maxi){
        if(root == null){
            return 0;
        }
        int leftMax = Math.max(maxSum(root.left, maxi), 0);
        int rightMax = Math.max(maxSum(root.right, maxi), 0);

        maxi[0] = Math.max(maxi[0], root.value+leftMax+rightMax);

        return root.value + Math.max(leftMax, rightMax);
    }
}
