package com.inn.trees;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class TreeDataStructure {

	private List<BinaryTreeNode> nodes;
	
	public TreeDataStructure() {
		this.nodes = new ArrayList<>();
	}
	
	public BinaryTreeNode addNode(String data) {
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		this.nodes.add(newNode);
		return newNode;
	}
	
	public void recuresivePreOrderTraversal(BinaryTreeNode rootNode) {
		if(rootNode == null) {
			return;
		}
		System.out.println(rootNode.getData());
		recuresivePreOrderTraversal(rootNode.getLeftChild());
		recuresivePreOrderTraversal(rootNode.getRightChild());
	}
	
	public void iterativePreOrderTraversal(BinaryTreeNode rootNode) {
		BinaryTreeNode tempNode = rootNode;
		while(tempNode != null) {
			
		}
	}
	
	public static void main(String[] args) {
		TreeDataStructure treeDataStructure = new TreeDataStructure();
		BinaryTreeNode aNode = treeDataStructure.addNode("A");
		BinaryTreeNode bNode = treeDataStructure.addNode("B");
		BinaryTreeNode cNode = treeDataStructure.addNode("C");
		BinaryTreeNode dNode = treeDataStructure.addNode("D");
		BinaryTreeNode eNode = treeDataStructure.addNode("E");
		BinaryTreeNode fNode = treeDataStructure.addNode("F");
		BinaryTreeNode gNode = treeDataStructure.addNode("G");
		BinaryTreeNode hNode = treeDataStructure.addNode("H");
		BinaryTreeNode iNode = treeDataStructure.addNode("I");
		
		// setting a node child's
		aNode.setLeftChild(bNode);
		aNode.setRightChild(cNode);
		
		// setting b node child's
		bNode.setRightChild(dNode);
		
		// setting c node child's
		cNode.setLeftChild(eNode);
		cNode.setRightChild(fNode);
		
		// setting e node child's
		eNode.setLeftChild(gNode);
		
		// setting f node child's
		fNode.setLeftChild(hNode);
		fNode.setRightChild(iNode);
		
		treeDataStructure.recuresivePreOrderTraversal(aNode);
	}

}
