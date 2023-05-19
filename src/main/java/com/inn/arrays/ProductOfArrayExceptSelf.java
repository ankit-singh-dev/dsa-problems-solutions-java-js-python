package com.inn.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] returnArray = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int product = 1;
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					product = product * nums[j];
				}
			}
			returnArray[i] = product;
		}
		return returnArray;
	}

}
