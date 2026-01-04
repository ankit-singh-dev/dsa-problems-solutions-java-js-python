package com.inn.trees;

/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */


import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode124 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rootLeft = new TreeNode(4);
        TreeNode rootLeftLeft = new TreeNode(11);
        TreeNode rootLeftLeftLeft = new TreeNode(7);
        TreeNode rootLeftLeftRight = new TreeNode(2);

        TreeNode rootRight = new TreeNode(8);
        TreeNode rootRightLeft = new TreeNode(13);
        TreeNode rootRightRight = new TreeNode(4);
        TreeNode rootRightRightRight = new TreeNode(1);

        root.left = rootLeft;
        root.right = rootRight;

        root.left.left = rootLeftLeft;
        root.left.left.left = rootLeftLeftLeft;
        root.left.left.right = rootLeftLeftRight;

        root.right.left = rootRightLeft;
        root.right.right = rootRightRight;
        root.right.right.right = rootRightRightRight;

        LeetCode124 obj = new LeetCode124();
        System.out.println(obj.maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[]{Integer.MIN_VALUE};
        pathSum(root, maxi);
        return maxi[0];
    }

    private int pathSum(TreeNode node, int[] maxi){
        if(node == null){
            return 0;
        }

        int leftSum = pathSum(node.left, maxi);
        int rightSum = pathSum(node.right, maxi);

        int opt1 = Math.max(node.value+leftSum, node.value+rightSum);
        int opt2 = Math.max(opt1, node.value+leftSum+rightSum);
        int res = Math.max(node.value, opt2);

        maxi[0] = Math.max(maxi[0], res);

        return res;

    }
}
