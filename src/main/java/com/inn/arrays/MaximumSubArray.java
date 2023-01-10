package com.inn.arrays;

/*
 * https://leetcode.com/problems/maximum-subarray/
 */

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] nums = { -5, 4, 6, -3, 4, 1 };
		int result = bruteForceMaxSubArray(nums);
		int result1 = kadaneAlgo(nums);
		System.out.println(result);
		System.out.println(result1);
	}

	private static int kadaneAlgo(int[] nums) {
		int start = 0;
		int end = 0;
		int startPnt = 0;
		int best = Integer.MIN_VALUE;
		int currentBest = 0;
		for (int i = 0; i < nums.length; i++) {
			currentBest = currentBest + nums[i];
			if(currentBest > best) {
				best = currentBest;
				start = startPnt;
				end = i;
			}
			if(currentBest < 0) {
				currentBest = 0;
				startPnt = i+1;
			}
		}
		System.out.println("max sum array is== start index "+start+" end is "+end);
		return best;
	}

	private static int bruteForceMaxSubArray(int[] nums) {
		int bestSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				bestSum = Math.max(sum, bestSum);
			}
		}
		return bestSum;
	}

}
