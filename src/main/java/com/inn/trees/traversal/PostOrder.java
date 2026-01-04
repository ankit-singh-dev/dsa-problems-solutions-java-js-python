package com.inn.trees.traversal;

import com.inn.trees.BinaryTreeNode;

public class PostOrder {

    // recursive solution
    public static void postOrder(BinaryTreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data + " ");
    }
}
