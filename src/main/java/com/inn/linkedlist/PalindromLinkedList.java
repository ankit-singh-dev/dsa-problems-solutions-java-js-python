package com.inn.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

/*
 * https://leetcode.com/problems/palindrome-linked-list/
 */

public class PalindromLinkedList {

	public static void main(String[] args) {
		Stack<Integer> integers = new Stack<>();
		integers.add(1);
		integers.add(2);
		integers.add(3);
		integers.add(4);
		integers.add(5);
		
		Iterator<Integer> itr = integers.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("=========================");
		Deque<Integer> integers1 = new ArrayDeque<>();
		integers1.add(1);
		integers1.add(2);
		integers1.add(3);
		integers1.add(4);
		integers1.add(5);
		
		Iterator<Integer> itr1 = integers1.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
	}

	private static boolean isPalindrome(ListNode head) {
		return false;
	}

}
