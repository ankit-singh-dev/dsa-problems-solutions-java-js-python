package com.inn.trees;

import java.util.Objects;
import java.util.Stack;

public class SearchInBST {

    // let use iterative approach
    public TreeNode searchBSTVal(TreeNode root, int val){

        if(root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode topNode = stack.pop();

            if(topNode.value == val){
                return topNode;
            }

            if(topNode.getValue() < val && Objects.nonNull(topNode.getRight())){
                // right side
                stack.push(topNode.getRight());
            }else if(topNode.getValue() > val && Objects.nonNull(topNode.getLeft())){
                stack.push(topNode.getLeft());
            }
        }

        return null;
    }

    // using recursive approach
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }
        if(root.value < val){
            // search in right side
            return searchBST(root.right, val);
        }else{
            // search in left side
            return searchBST(root.left, val);
        }
    }
}
