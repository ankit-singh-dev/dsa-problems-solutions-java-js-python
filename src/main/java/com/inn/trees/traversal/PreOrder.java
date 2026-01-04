package com.inn.trees.traversal;

import com.inn.trees.BinaryTreeNode;

import java.util.Stack;

public class PreOrder {

    public static void main(String[] args) {

    }

    public static void iterativePreOrderTraversal(BinaryTreeNode root){

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()){

            BinaryTreeNode top = stack.peek();
            System.out.print(top.getData() + " ");

            stack.pop();
            if(top.getRightChild() != null){
                stack.add(top.getRightChild());
            }
            if(top.getLeftChild() != null){
                stack.add(top.getLeftChild());
            }
        }
    }

    public static void preOrderTraversal(BinaryTreeNode root){

        if(root == null){
            return;
        }

        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

}
