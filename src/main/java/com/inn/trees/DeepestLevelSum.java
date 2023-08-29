package com.inn.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/deepest-leaves-sum/
 */

class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
        this.value = -1;
    }
    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}


public class DeepestLevelSum {

	public static void main(String[] args) {

	}

	public int deepestLeavesSum(TreeNode root) {
		int sum = 0;
		if (root == null) {
			return sum;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			int currSum = 0;
			
			for(int i=0;i<size;i++) {
				TreeNode node = queue.poll();
				if(node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if(node.getRight() != null) {
					queue.add(node.getRight());
				}
				currSum = currSum + node.getValue();
			}
			sum = currSum;
		}
		
		
		return sum;
	}

}
