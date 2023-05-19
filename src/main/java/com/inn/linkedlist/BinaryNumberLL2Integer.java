package com.inn.linkedlist;

import lombok.Setter;

/*
 * Leetcode-1290
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */

@Setter
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public int getDecimalValue(ListNode head) {

		// approach 1
		/*
		StringBuilder builder = new StringBuilder("");
		while (head != null) {
			builder.append(head.val);
			head = head.next;
		}
		return Integer.parseInt(builder.toString(), 2);
		*/

		// approach 2
		int ans = 0;
		while (head != null) {
			ans = ans * 2;
			ans = ans + (head.val * 1);
			head = head.next;
		}
		return ans;
	}
}

public class BinaryNumberLL2Integer {

	public static void main(String[] args) {

	}

}
