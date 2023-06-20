package com.inn.sortingsearching;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class LeetCode34 {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}

	private static int[] searchRange(int[] nums, int target) {

		int[] firstAndLastOccurancesOfTarget = new int[2];
		int firstOccurrence = -1;
		int lastOccurrence = -1;

		int start = 0;
		int end = nums.length - 1;

		// first occurrences of target
		while (start <= end) {
			int mid = (start + (end - start) / 2);
			if (nums[mid] == target) {
				firstOccurrence = mid;
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		start = 0;
		end = nums.length - 1;
		// last occurrences of target
		while (start <= end) {
			int mid = (start + (end - start) / 2);
			if (nums[mid] == target) {
				lastOccurrence = mid;
				start = mid + 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		firstAndLastOccurancesOfTarget[0] = firstOccurrence;
		firstAndLastOccurancesOfTarget[1] = lastOccurrence;
		return firstAndLastOccurancesOfTarget;
	}
}
