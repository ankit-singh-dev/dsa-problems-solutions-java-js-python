package com.inn.arrays;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/sort-colors/
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */

public class Sort012 {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 0, 1, 2 };
		dutchNationFlagAlgo(nums);
	}

	private static void dutchNationFlagAlgo(int[] nums) {
		int length = nums.length;
		int low = 0; 
		int mid = 0; 
		int high = length - 1;
		
		while(mid <= high) {
			int temp = 0;
			if(nums[mid] == 0) {
				// swap nums[low] and nums[mid]
				temp = nums[mid];
				nums[mid] = nums[low];
				nums[low] = temp;
				low++;
				mid++;
			}else if(nums[mid] == 1) {
				mid++;
			}else if(nums[mid] == 2) {
				// swap nums[mid] and nums[high]
				temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	private static void sort012(int[] nums) {
		int zero = 0;
		int one = 0;
		int two = 0;
		for (int no : nums) {
			if (no == 0) {
				zero++;
			} else if (no == 1) {
				one++;
			} else {
				two++;
			}
		}
		for (int i = 0; i < zero; i++) {
			nums[i] = 0;
		}
		for (int i = zero; i < (zero + one); i++) {
			nums[i] = 1;
		}
		for (int i = (zero + one); i < (zero + one + two); i++) {
			nums[i] = 2;
		}
		System.out.println(Arrays.toString(nums));
	}

}
