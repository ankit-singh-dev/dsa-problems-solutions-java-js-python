package com.inn.trees.traversal;

import com.inn.trees.BinaryTreeNode;

import java.util.*;

public class InOrder {

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode("5");
        BinaryTreeNode node1 = new BinaryTreeNode("3");
        BinaryTreeNode node2 = new BinaryTreeNode("8");
        BinaryTreeNode node3 = new BinaryTreeNode("2");
        BinaryTreeNode node4 = new BinaryTreeNode("4");

        root.setLeftChild(node1);
        root.setRightChild(node2);

        node1.setLeftChild(node3);
        node1.setRightChild(node4);

        inOrderTraversal(root);
        System.out.println();
        iterativeInOrder(root);
    }

    /*
    Recursive solution
     */
    public static void inOrderTraversal(BinaryTreeNode root){
        if (Objects.isNull(root)){
            return;
        }
        inOrderTraversal(root.getLeftChild());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRightChild());
    }

    public static void iterativeInOrder(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;

        while (Objects.nonNull(current) || !stack.isEmpty()){

            // move to the left most node
            // we will stop if any node doesn't have any left sub child
            while (Objects.nonNull(current)){
                stack.push(current);
                current = current.getLeftChild();
            }

            // pop the leftmost node
            BinaryTreeNode topNode = stack.pop();
            System.out.print(topNode.getData() + " ");

            // check if the topNode has right sub child
            current = topNode.getRightChild();
        }
    }
}
