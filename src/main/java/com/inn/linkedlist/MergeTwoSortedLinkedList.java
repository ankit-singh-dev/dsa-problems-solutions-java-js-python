package com.inn.linkedlist;

class Node1 {
	int data;
	Node1 prev;
	Node1 next;

	public Node1() {
	}

	public Node1(int data) {
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
		Node1 ll11 = new Node1(10);
		Node1 ll12 = new Node1(50);
		Node1 ll13 = new Node1(70);
		Node1 ll14 = new Node1(90);
		Node1 ll15 = new Node1(100);
		ll11.next = ll12;
		ll12.prev = ll11;
		
		ll12.next = ll13;
		ll13.prev = ll12;
		
		ll13.next = ll14;
		ll14.prev = ll13;
		
		ll14.next = ll15;
		ll15.prev = ll14;

		Node1 ll21 = new Node1(20);
		Node1 ll22 = new Node1(30);
		Node1 ll23 = new Node1(40);
		Node1 ll24 = new Node1(60);
		Node1 ll25 = new Node1(80);
		ll21.next = ll22;
		ll22.prev = ll21;
		
		ll22.next = ll23;
		ll23.prev = ll22;
		
		ll23.next = ll24;
		ll24.prev = ll23;
		
		ll24.next = ll25;
		ll25.prev = ll24;

		Node1 ansNode = mergeSortedLL(ll11, ll21);
		while(ansNode != null) {
			System.out.print(ansNode + "->");
			ansNode = ansNode.next;
		}
	}

	private static Node1 mergeSortedLL(Node1 linkedList1, Node1 linkedList2) {

		boolean isSortedHeadFound = false;
		Node1 firstNode = null;

		Node1 p = linkedList1;
		Node1 q = linkedList2;
		Node1 s = null;

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
