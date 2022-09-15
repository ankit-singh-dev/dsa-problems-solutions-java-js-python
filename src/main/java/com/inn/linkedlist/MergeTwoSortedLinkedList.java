package com.inn.linkedlist;

class Node {
	int data;
	Node prev;
	Node next;

	public Node() {
	}

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return "[data=" + data + "]";
	}
}

public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		Node ll11 = new Node(10);
		Node ll12 = new Node(50);
		Node ll13 = new Node(70);
		Node ll14 = new Node(90);
		Node ll15 = new Node(100);
		ll11.next = ll12;
		ll12.prev = ll11;
		
		ll12.next = ll13;
		ll13.prev = ll12;
		
		ll13.next = ll14;
		ll14.prev = ll13;
		
		ll14.next = ll15;
		ll15.prev = ll14;

		Node ll21 = new Node(20);
		Node ll22 = new Node(30);
		Node ll23 = new Node(40);
		Node ll24 = new Node(60);
		Node ll25 = new Node(80);
		ll21.next = ll22;
		ll22.prev = ll21;
		
		ll22.next = ll23;
		ll23.prev = ll22;
		
		ll23.next = ll24;
		ll24.prev = ll23;
		
		ll24.next = ll25;
		ll25.prev = ll24;

		Node ansNode = mergeSortedLL(ll11, ll21);
		while(ansNode != null) {
			System.out.print(ansNode + "->");
			ansNode = ansNode.next;
		}
	}

	private static Node mergeSortedLL(Node linkedList1, Node linkedList2) {

		boolean isSortedHeadFound = false;
		Node firstNode = null;

		Node p = linkedList1;
		Node q = linkedList2;
		Node s = null;

		while (p != null && q != null) {
			if (p.data <= q.data) {
				if (s == null) {
					// first node
					s = p;
					if (!isSortedHeadFound) {
						firstNode = linkedList1;
						isSortedHeadFound = true;
					}
				} else {
					s.next = p;
					p.prev = s;
					s = p;
				}
				p = p.next;
			} else if (p.data > q.data) {
				if (s == null) {
					// first node
					s = q;
					if (!isSortedHeadFound) {
						firstNode = linkedList2;
						isSortedHeadFound = true;
					}
				} else {
					s.next = q;
					q.prev = s;
					s = q;
				}
				q = q.next;
			}
		}
		if (q == null) {
			s.next = p;
		} else if (p == null) {
			s.next = q;
		}
		
		return firstNode;
	}

}
