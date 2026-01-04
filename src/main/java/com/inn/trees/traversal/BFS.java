package com.inn.trees.traversal;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
https://www.geeksforgeeks.org/problems/level-order-traversal/1
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();
            while (size > 0){
                TreeNode node = queue.poll();
                innerList.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                size--;
            }
            res.add(innerList);

        }
        return res;
    }

}
