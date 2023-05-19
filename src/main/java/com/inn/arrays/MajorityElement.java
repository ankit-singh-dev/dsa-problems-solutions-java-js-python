package com.inn.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://leetcode.com/problems/majority-element/description/
 */

public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };
		System.out.println(mooreVotingAlgo(nums));
	}
	
	public static int mooreVotingAlgo(int[] nums) {
		int candidate = nums[0];
		int votes = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] == candidate) {
				votes = votes+1;
			}else {
				votes = votes-1;
			}
			
			if(votes == 0) {
				candidate = nums[i];
				votes = 1;
			}
		}
		
		final int candidateCopy = candidate;
		int count = (int) Arrays.stream(nums)
			.filter(x -> x == candidateCopy)
			.count();
		
		if(count > (nums.length/2)) {
			return candidate;
		}
		return -1;
	}

	private static int usingHashing(int[] nums) {
		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int no : nums) {
			int existingCount = map.getOrDefault(no, 0);
			map.put(no, existingCount + 1);
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > (length / 2)) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
