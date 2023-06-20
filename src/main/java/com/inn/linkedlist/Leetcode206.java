package com.inn.linkedlist;

/*
 * https://leetcode.com/problems/reverse-linked-list/description/
 */

public class Leetcode206 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode res = reverseListRecursive(node1);
		System.out.println(res.val);
	}
	
	private static ListNode reverseLinkedListUsingAddFirstTech(ListNode head) {
		ListNode crnt = head;
		while(crnt != null) {
			ListNode next = crnt.next;
			crnt.next = null;
			addFirst(crnt);
			crnt = next;
		}
		return tempHead;
	}
	
	static ListNode tempHead = null;
	static ListNode tempTail = null;
	private static void addFirst(ListNode node) {
		if(tempHead == null) {
			tempHead = node;
			tempTail = node;
		}else {
			node.next = tempHead;
			tempHead = node;
		}
	}

	private static ListNode reverseListRecursive(ListNode head) {
		if (head == null || head.next == null)
			return head;

		/*
		 * reverse the rest list and put the first element at the end
		 */
		ListNode rest = reverseListRecursive(head.next);
		head.next.next = head;

		/* tricky step -- see the diagram */
		head.next = null;

		/* fix the head pointer */
		return rest;
	}

	private static ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode previous = null;
		while (current != null) {
			ListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

}
