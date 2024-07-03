package com.inn.hashing;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1796 {

	public static void main(String[] args) {
		String s = "dfa12321afd";
		System.out.println(secondHighest(s));
	}

	private static int secondHighest(String s) {
		Set<Integer> nos = new HashSet<>();
		for(char ch : s.toCharArray()) {
			if(ch >= 48 && ch <= 57) {
				nos.add(Character.getNumericValue(ch));
			}
		}
		return secondLargestInList(nos);
	}
	
	private static int secondLargestInList(Set<Integer> nos) {
		if(nos.isEmpty() || nos.size() == 1) {
			return -1;
		}
		
		return nos.stream()
			.sorted(Comparator.reverseOrder())
			.skip(1)
			.findFirst()
			.orElse(-1);
	}

}
