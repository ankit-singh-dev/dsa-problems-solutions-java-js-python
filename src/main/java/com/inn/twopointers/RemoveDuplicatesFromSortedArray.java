package com.inn.twopointers;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1,1,2 };
		System.out.println(removeDuplicatesUsingExtraSpace(arr));
		System.out.println(removeDuplicates(arr));
	}
	
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int j = 0;
		for(int i=0;i<n-1;i++) {
			if(nums[i] != nums[i+1]) {
				nums[j++] = nums[i];
			}
		}
		nums[j++] = nums[n-1];
		return j;
	}

	private static int removeDuplicatesUsingExtraSpace(int[] nums) {
		int n = nums.length;
		int[] temp = new int[n];
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if(nums[i] != nums[i+1]) {
				temp[j++] = nums[i];
			}
		}
		temp[j++] = nums[n-1];
		for(int i=0;i<j;i++) {
			nums[i] = temp[i];
		}
		return j;
	}
}
