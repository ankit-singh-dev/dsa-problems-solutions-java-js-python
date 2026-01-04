package com.inn.trees;

/*
https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        height(root, maxi);
        return maxi[0];
    }

    private int height(TreeNode root, int[] maxi){

        if(root == null){
            return 0;
        }

        int leftHeight = height(root.left, maxi);
        int rightHeight = height(root.right, maxi);

        maxi[0] = Math.max(maxi[0], leftHeight+rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }


}
