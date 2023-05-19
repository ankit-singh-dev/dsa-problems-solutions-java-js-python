package com.inn.twopointers;

/*
 * https://leetcode.com/problems/remove-element/description/
 */

public class LeetCode27 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println(removeElementUsingExtraSpace(nums, val));
		System.out.println(removeElement(nums, val));
	}

	private static int removeElement(int[] nums, int val) {
		int j = 0;
		for(int no : nums) {
			if(no != val) {
				nums[j++] = no;
			}
		}
		return j;
	}

	private static int removeElementUsingExtraSpace(int[] nums, int val) {
		int[] tempArray = new int[nums.length];
		int j = 0;
		
		for(int no : nums) {
			if(no != val) {
				tempArray[j++] = no;
			}
		}
		
		for(int i=0;i<j;i++) {
			nums[i] = tempArray[i];
		}
		return j;
	}

}
