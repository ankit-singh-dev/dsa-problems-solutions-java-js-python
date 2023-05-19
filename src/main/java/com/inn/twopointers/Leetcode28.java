package com.inn.twopointers;

/*
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */

public class Leetcode28 {

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issip";
		System.out.println(strStr(haystack, needle));
	}

	// not working
	private static int strStr(String haystack, String needle) {
		int j = 0;
		for(int i=0;i<haystack.length();i++) {
			if(haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}else if(j > 0){
				j = 0;
			}
			if(j == needle.length()) {
				return (i-(needle.length()-1));
			}
		}
		return -1;
	}

}
