package com.inn.trees;

/*
https://leetcode.com/problems/binary-tree-tilt/description/
 */

public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        int[] sum = new int[]{0};
        findSumTitl(root, sum);
        return sum[0];
    }

    private int findSumTitl(TreeNode root, int[] sum){
        if(root == null){
            return 0;
        }
        int leftTilt = findSumTitl(root.left, sum);
        int rightTilt = findSumTitl(root.right, sum);

        sum[0] = sum[0] + Math.abs(leftTilt-rightTilt);
        return root.value + leftTilt + rightTilt;
    }


}
