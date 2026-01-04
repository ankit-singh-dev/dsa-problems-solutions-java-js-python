package com.inn.trees;

/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 */

import java.util.Objects;
import java.util.Stack;

public class InsertIntoBinaryTree {

    private static TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode justBeforeNode = null;

        boolean isLeft = true;
        while (!stack.isEmpty()){
            TreeNode topNode = stack.pop();
            justBeforeNode = topNode;
            if(val < topNode.getValue()){
                // move left side
                isLeft = true;
                if(Objects.nonNull(topNode.getLeft())){
                    stack.push(topNode.getLeft());
                }
            }else{
                // move right side
                isLeft = false;
                if(Objects.nonNull(topNode.getRight())){
                    stack.push(topNode.getRight());
                }
            }
        }

        TreeNode newNode = new TreeNode(val);
        if (isLeft){
            justBeforeNode.setRight(newNode);
        }else {
            justBeforeNode.setRight(newNode);
        }

        return root;

    }
}
