package com.inn.arrays;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1
 */

public class WaveArray {

	public static void main(String[] args) {
		int nums[] = {10, 5, 6, 3, 2, 20, 100, 80};
		waveSort(nums);
	}

	private static void waveSort(int[] nums) {
		int length = nums.length;
		
		for(int i=0;i<length-1;i=i+2) {
			if(i > 0 && nums[i] < nums[i-1]) {
				// swap it
				int temp = nums[i];
				nums[i] = nums[i-1];
				nums[i-1] = temp;
			}
			
			if(nums[i] < nums[i+1]) {
				// again swap it
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
