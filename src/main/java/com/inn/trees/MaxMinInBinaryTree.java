package com.inn.trees;

/*
https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1
 */

import java.util.Stack;

public class MaxMinInBinaryTree {

    static int[] maxMinValue = new int[2];

    public static void main(String[] args) {
        BinaryTreeNode one = new BinaryTreeNode("4");
        BinaryTreeNode two = new BinaryTreeNode("2");
        BinaryTreeNode three = new BinaryTreeNode("3");
        BinaryTreeNode four = new BinaryTreeNode("4");
        BinaryTreeNode five = new BinaryTreeNode("5");
        BinaryTreeNode six = new BinaryTreeNode("6");
        BinaryTreeNode seven = new BinaryTreeNode("7");

        /*
        one.setLeftChild(two);
        one.setRightChild(three);

        two.setLeftChild(four);
        two.setRightChild(five);

        three.setLeftChild(six);
        three.setRightChild(seven);

         */

        System.out.println(findMax(one));
        System.out.println(findMin(one));
    }

    public static int findMax(BinaryTreeNode root) {
        // code here
        return preOrderTraversal(root)[0];
    }

    public static int findMin(BinaryTreeNode root) {

        // code here
        return preOrderTraversal(root)[1];
    }

    private static int[] preOrderTraversal(BinaryTreeNode root){

        if(maxMinValue[0] > 0 && maxMinValue[1] > 0){
            return maxMinValue;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            BinaryTreeNode topNode = stack.pop();
            max = Math.max(Integer.parseInt(topNode.getData()), max);
            min = Math.min(Integer.parseInt(topNode.getData()), min);

            if(topNode.getRightChild() != null){
                stack.push(topNode.getRightChild());
            }

            if(topNode.getLeftChild() != null){
                stack.push(topNode.getLeftChild());
            }
        }
        maxMinValue[0] = max;
        maxMinValue[1] = min;
        return maxMinValue;
        //return new int[]{max, min};
    }
}
