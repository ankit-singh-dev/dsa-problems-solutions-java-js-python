package com.inn.trees;

import java.util.Objects;
import java.util.Stack;

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        TreeNode one = new TreeNode(-2147483648);

        root.left = one;

        System.out.println(isValidBST(root));
    }

    // using InOrder traversal
    // since inOrder traversal gives nodes value in sorted format
    // we will just check if the values are sorted or not
    public static boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        Integer prev = null;

        while (Objects.nonNull(current) || !stack.isEmpty()){

            while (Objects.nonNull(current)){
                stack.push(current);
                current = current.left;
            }

            TreeNode topNode = stack.pop();
            if (prev != null && topNode.value <= prev){
                return false;
            }
            prev = topNode.value;

            current = topNode.right;
        }
        
        return true;
    }
}
