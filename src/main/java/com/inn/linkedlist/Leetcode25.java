package com.inn.linkedlist;

/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class Leetcode25 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		//ListNode node3 = new ListNode(3);
		//ListNode node4 = new ListNode(4);
		//ListNode node5 = new ListNode(5);
		// ListNode node6 = new ListNode(6);
		// ListNode node7 = new ListNode(7);

		node1.setNext(node2);
		//node2.setNext(node3);
		//node3.setNext(node4);
		//node4.setNext(node5);
		// node5.setNext(node6);
		// node6.setNext(node7);

		ListNode nayaHead = reverseKGroup(node1, 2);
		while (nayaHead != null) {
			System.out.println(nayaHead.val);
			nayaHead = nayaHead.next;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		int linkedListSize = calculateLength(head);
		ListNode crntNode = head;
		int count = k;
		int cycle = linkedListSize/k;
		while (cycle > 0) {
			if (count == 0) {
				count = k;
				cycle = cycle - 1;
				if(cycle == 0) {
					break;
				}
			}
			ListNode frwd = crntNode.next;
			crntNode.next = null;
			count = count - 1;
			addFirst(crntNode, count);
			crntNode = frwd;
		}
		originalTail.next = crntNode;
		return originalHead;
	}

	static ListNode tempHead = null;
	static ListNode tempTail = null;
	static ListNode originalHead = null;
	static ListNode originalTail = null;

	private static void addFirst(ListNode node, int count) {
		if (tempHead == null) {
			tempHead = node;
			tempTail = node;
		} else {
			node.next = tempHead;
			tempHead = node;
		}
		
		if (count == 0) {
			if (originalHead == null) {
				originalHead = tempHead;
				originalTail = tempTail;
			} else {
				originalTail.next = tempHead;
				originalTail = tempTail;
			}

			tempHead = null;
			tempTail = null;

		}
	}

	private static int calculateLength(ListNode headNode) {
		ListNode crnt = headNode;
		int count = 0;
		while (crnt != null) {
			count++;
			crnt = crnt.next;
		}
		return count;
	}

	private static int calculateLengthRecursive(ListNode headNode) {
		if (headNode == null) {
			return 0;
		}
		return 1 + calculateLengthRecursive(headNode.next);
	}

}
