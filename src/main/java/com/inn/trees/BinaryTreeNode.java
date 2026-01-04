package com.inn.trees;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class BinaryTreeNode {
	
	public String data;
	public BinaryTreeNode leftChild;
	public BinaryTreeNode rightChild;

	public BinaryTreeNode(String data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public BinaryTreeNode addNode(String data) {
		return new BinaryTreeNode(data);
	}
}
