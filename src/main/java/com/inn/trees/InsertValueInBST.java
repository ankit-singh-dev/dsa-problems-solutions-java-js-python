package com.inn.trees;

import lombok.Data;

import java.util.*;

public class InsertValueInBST {

    @Data
    private static final class BinarySearchNode{
        int value;
        BinarySearchNode left;
        BinarySearchNode right;
    }

    private static BinarySearchNode root;
    private static BinarySearchNode justBeforeNode;

    public static void main(String[] args) {
        List<Integer> values = List.of(50, 20, 23, 60, 12, 97, 29);
        for(int no : values){
            addValue(no);
        }
        printTrees();
    }

    private static void printTrees(){
        // printing tree in preorder format
        BinarySearchNode temp = root;
        Stack<BinarySearchNode> stack = new Stack<>();
        stack.push(temp);
        while (!stack.isEmpty()){
            BinarySearchNode topNode = stack.pop();

            System.out.print(topNode.getValue() + " ");

            if(Objects.nonNull(topNode.getRight())){
                stack.push(topNode.getRight());
            }
            if(Objects.nonNull(topNode.getLeft())){
                stack.push(topNode.getLeft());
            }
        }

        System.out.println();

        // printing tree in level order (BFS)

        Queue<BinarySearchNode> queue = new LinkedList<>();
        queue.offer(temp);

        while (!queue.isEmpty()){

            BinarySearchNode head = queue.poll();
            System.out.print(head.getValue() + " ");

            if(Objects.nonNull(head.getLeft())){
                queue.offer(head.getLeft());
            }
            if(Objects.nonNull(head.getRight())){
                queue.offer(head.getRight());
            }
        }
    }

    // assuming value won't be duplicated
    private static void addValue(int value){
        if(root == null){
            // root node
            BinarySearchNode firstNode = new BinarySearchNode();
            firstNode.setValue(value);
            root = firstNode;
            return;
        }

        boolean isLeft = true;
        Stack<BinarySearchNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinarySearchNode topNode = stack.pop();
            justBeforeNode = topNode;

            if(value > topNode.getValue()){
                // move at right sub tree
                isLeft = false;
            }else if(value < topNode.getValue()){
                // move at left sub tree
                isLeft = true;
            }

            if(!isLeft && Objects.nonNull(topNode.getRight())) {
                stack.push(topNode.getRight());
            }else if(isLeft && Objects.nonNull(topNode.getLeft())){
                stack.push(topNode.getLeft());
            }
        }
        BinarySearchNode newNode = new BinarySearchNode();
        newNode.setValue(value);
        if(isLeft){
            justBeforeNode.setLeft(newNode);
        }else{
            justBeforeNode.setRight(newNode);
        }
    }
}
