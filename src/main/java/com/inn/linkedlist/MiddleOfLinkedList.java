package com.inn.linkedlist;

 
/*
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/submissions/
 */

public class MiddleOfLinkedList {
	
	public SinglyNode middleNode(SinglyNode headNode) {
		if(headNode == null) {
			return null;
		}
		SinglyNode slowPointer = headNode;
		SinglyNode fastPointer = headNode;
		
		while(fastPointer != null && fastPointer.getNext() != null) {
			slowPointer = slowPointer.getNext();
			fastPointer = fastPointer.getNext().getNext();
		}
		
		return slowPointer;
	}

	public static void main(String[] args) {
		SinglyNode node1 = new SinglyNode("1");
		SinglyNode node2 = new SinglyNode("2");
		SinglyNode node3 = new SinglyNode("3");
		SinglyNode node4 = new SinglyNode("4");
		SinglyNode node5 = new SinglyNode("5");
		SinglyNode node6 = new SinglyNode("6");
		SinglyNode node7 = new SinglyNode("7");
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);
		
		MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
		SinglyNode middleNode = middleOfLinkedList.middleNode(node1);
		System.out.println(middleNode.getData());
	}

}
