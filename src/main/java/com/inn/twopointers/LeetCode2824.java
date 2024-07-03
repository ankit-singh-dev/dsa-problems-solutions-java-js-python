package com.inn.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 */

public class LeetCode2824 {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(-6);
		nums.add(2);
		nums.add(5);
		nums.add(-2);
		nums.add(-7);
		nums.add(-1);
		nums.add(3);
		
		int target = -2;
		System.out.println(countPairsUsingTwoLoop(nums, target));
		System.out.println(countPairs(nums, target));
	}
	
	private static int countPairs(List<Integer> nums, int target) {
		// -6,2,5,-2,-7,-1,3
		// [-7, -6, -2, -1, 2, 3, 5]
		
		Collections.sort(nums);
		System.out.println(nums);
		int count = 0;
		
		int i = 0;
		int j = i+1;
		
		while(true) {
			if(nums.get(i) + nums.get(j) < target) {
				count++;
			}
			if(target == 12) {
				break;
			}
		}
		return count;
	}

	private static int countPairsUsingTwoLoop(List<Integer> nums, int target) {
		int count = 0;
		for (int i = 0; i < nums.size(); i++) {
			for (int j = i+1; j < nums.size(); j++) {
				if(nums.get(i) + nums.get(j) < target) {
					count++;
				}
			}
		}
		return count;
	}
}
