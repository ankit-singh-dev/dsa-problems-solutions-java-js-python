package com.inn.hashing;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * https://www.geeksforgeeks.org/number-subarrays-sum-exactly-equal-k/
 */

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int arr[] = {9, 4, 20, 3, 10, 5};
		int k = 33;
		int result = usingHashing(arr,k);
		System.out.println(result);
	}
	
	private static int usingHashing(int[] arr, int k) {
		return 0;
	}

	private static int bruteForceApproach(int[] arr, int k) {
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			int sum = 0;
			for(int j=i;j<arr.length;j++) {
				sum = sum + arr[j];
				if(sum == k) {
					count++;
				}
			}
		}
		return count;
	}

}
