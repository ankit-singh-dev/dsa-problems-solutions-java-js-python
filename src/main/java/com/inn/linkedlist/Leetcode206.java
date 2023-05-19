package com.inn.linkedlist;

/*
 * https://leetcode.com/problems/reverse-linked-list/description/
 */

public class Leetcode206 {

	public static void main(String[] args) {

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
