package com.inn.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthInTree {

    // using recursive
    public int maxDepthUsingRecursion(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = maxDepthUsingRecursion(root.left);
        int rightHeight = maxDepthUsingRecursion(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // using iterative solution
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode headNode = queue.poll();
                if(headNode.left != null){
                    queue.offer(headNode.left);
                }
                if(headNode.right != null){
                    queue.offer(headNode.right);
                }
            }
        }
        return level;
    }
}
