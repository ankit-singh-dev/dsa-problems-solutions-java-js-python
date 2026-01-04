package com.inn.trees.traversal;

import com.inn.trees.BinaryTreeNode;

public class TestTraversal {

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode("1");
        BinaryTreeNode two = new BinaryTreeNode("2");
        BinaryTreeNode three = new BinaryTreeNode("3");
        BinaryTreeNode four = new BinaryTreeNode("4");
        BinaryTreeNode five = new BinaryTreeNode("5");
        BinaryTreeNode six = new BinaryTreeNode("6");
        BinaryTreeNode seven = new BinaryTreeNode("7");
        BinaryTreeNode eight = new BinaryTreeNode("8");
        BinaryTreeNode nine = new BinaryTreeNode("9");
        BinaryTreeNode ten = new BinaryTreeNode("10");
        BinaryTreeNode oneOne = new BinaryTreeNode("11");
        BinaryTreeNode oneTwo = new BinaryTreeNode("12");
        BinaryTreeNode oneThree = new BinaryTreeNode("13");
        BinaryTreeNode oneFour = new BinaryTreeNode("14");
        BinaryTreeNode oneFive = new BinaryTreeNode("15");

        root.leftChild = two;
        root.rightChild = three;

        two.leftChild = four;
        two.rightChild = five;

        three.leftChild = six;
        three.rightChild = seven;

        four.leftChild = eight;
        four.rightChild = nine;

        five.leftChild = ten;
        five.rightChild = oneOne;

        six.leftChild = oneTwo;
        six.rightChild = oneThree;

        seven.leftChild = oneFour;
        seven.rightChild = oneFive;

        PreOrder.preOrderTraversal(root);
        System.out.println();
        PreOrder.iterativePreOrderTraversal(root);
        System.out.println();

        InOrder.inOrderTraversal(root);
        System.out.println();
        InOrder.iterativeInOrder(root);
        System.out.println();

        PostOrder.postOrder(root);

    }
}
