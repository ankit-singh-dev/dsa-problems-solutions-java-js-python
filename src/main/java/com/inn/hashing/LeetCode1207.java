package com.inn.hashing;

/*
 * https://leetcode.com/problems/unique-number-of-occurrences/description/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1207 {

	public static void main(String[] args) {
		int[] arr = {1,2,2,1,1,3};
		System.out.println(uniqueOccurrences(arr));
	}

	private static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int no : arr) {
			map.put(no, map.getOrDefault(no, 0)+1);
		}
		
		Set<Integer> valuesSet = new HashSet<>(map.values()); 
		return map.size() == valuesSet.size();
	}

}
