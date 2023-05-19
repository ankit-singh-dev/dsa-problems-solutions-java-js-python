package com.inn.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
 */

public class KthLargest {

	public static void main(String[] args) {
		int[] nums = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		int result = findKthLargestUsingHeap(nums, k);
		System.out.println(result);
	}

	private static int findKthLargestUsingHeap(int[] nums, int k) {
		PriorityQueue<Integer> integers = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			integers.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if(integers.peek() < nums[i]) {
				integers.poll();
				integers.add(nums[i]);
			}
		}
		return integers.peek();
	}

	private static int findKthLargestUsingSorting(int[] nums, int k) {
		// sort an array
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			if ((k + i) == nums.length) {
				return nums[i];
			}
		}
		return -1;
	}

}
