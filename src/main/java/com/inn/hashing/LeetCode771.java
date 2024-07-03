package com.inn.hashing;

/*
 * https://leetcode.com/problems/jewels-and-stones/description/
 */

import java.util.HashSet;
import java.util.Set;

public class LeetCode771 {

	public static void main(String[] args) {
		String jewels = "z", stones = "ZZ";
		System.out.println(numJewelsInStones(jewels, stones));
		System.out.println(numJewelsInStonesBetterApproach(jewels, stones));
	}

	private static int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		char[] jewwlls = jewels.toCharArray();
		Set<Character> set = new HashSet<>();
		for(Character ch : jewwlls) {
			set.add(ch);
		}
		
		char[] stonesArray = stones.toCharArray();
		for(char ch : stonesArray) {
			if(set.contains(ch)) {
				count++;
			}
		}
		return count;
	}
	
	private static int numJewelsInStonesBetterApproach(String jewels, String stones) {
		int[] charA = new int[256];
		
		for(char ch : stones.toCharArray()) {
			charA[ch]++;
		}
		
		int count = 0;
		for(char ch : jewels.toCharArray()) {
			if(charA[ch] > 0) {
				count += charA[ch];
			}
		}
		return count;
	}

}
