package com.inn.trees.traversal;

/*
https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class NArrayBFS {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                Node item = queue.poll();
                innerList.add(item.val);
                for (Node n : item.children){
                    queue.offer(n);
                }
                size--;
            }
            res.add(innerList);
        }

        return res;
    }
}
