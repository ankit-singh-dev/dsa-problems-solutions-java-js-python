package com.inn.trees;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */

import java.util.*;

public class ZigZagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode headNode = queue.poll();
                temp.add(headNode.value);

                if(headNode.left != null){
                    queue.offer(headNode.left);
                }
                if(headNode.right != null){
                    queue.offer(headNode.right);
                }
            }
            if(flag == 0){
                list.add(temp);
                flag = 1;
            }else if(flag == 1){
                //list.add(temp);
                // reverse temp and than add it to list
                Collections.reverse(temp);
                list.add(temp);
                flag = 0;
            }
        }

        return list;
    }
}
