package com.inn.linkedlist;

/*
 * https://leetcode.com/problems/reorder-list/description/
 */

public class Leetcode143 {
	
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode5 = new ListNode(5);
		
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = null;
		
		reorderList(listNode1);
	}

	private static void reorderList(ListNode head) {
		// base case
		if(head == null || head.next == null) {
			return;
		}
		
		// find the middle element
		ListNode middleNode = getMiddleNode(head);
		
		// reverse second half
		ListNode reverseSecondHalf = reverseSecondHalf(middleNode);
		
		// merge both of the list
		ListNode firstPointer = head;
		ListNode secondPointer = reverseSecondHalf;
		
		while(firstPointer != secondPointer) {
			ListNode firstNext = firstPointer.next;
			ListNode secondNext = secondPointer.next;
			
			firstPointer.next = secondPointer;
			secondPointer.next = firstNext;
			
			firstPointer = firstNext;
			secondPointer = secondNext;
		}
		
	}
	
	private static ListNode reverseSecondHalf(ListNode headNode) {
		
		ListNode currentNode = headNode;
		ListNode previous = null;
		while(currentNode != null) {
			ListNode nextNode = currentNode.next; // 3
			currentNode.next = previous; // null
			previous = currentNode; // 1
			currentNode = nextNode; // 2
		}
		
		return previous;
	}

	private static ListNode getMiddleNode(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		
		while(slowPointer.next != null && fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		return slowPointer;
	}

}
