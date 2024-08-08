package com.inn.slidingwindow;

/*
https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithLengthKUniqueElements {

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int K = 3;
        System.out.println(longestkSubstr(s, K));
    }

    public static int longestkSubstr(String s, int k) {
        // code here
        int longestStr = -1;
        Map<Character, Integer> maps = new HashMap<>(s.length());
        int windowStart = 0;
        int windowEnd = 0;
        while (windowEnd < s.length()) {
            // expansion
            maps.put(s.charAt(windowEnd), maps.getOrDefault(s.charAt(windowEnd), 0) + 1);
            if (maps.size() == k) {
                // there can be chances
                longestStr = Math.max(longestStr, windowEnd - windowStart + 1);
            } else if (maps.size() > k) {
                // shrinking
                while (maps.size() > k && windowStart < windowEnd) {
                    maps.put(s.charAt(windowStart), maps.getOrDefault(s.charAt(windowStart), 0) - 1);
                    if (maps.get(s.charAt(windowStart)) == 0) {
                        maps.remove(s.charAt(windowStart));
                    }
                    windowStart++;
                    if (maps.size() == k) {
                        longestStr = Math.max(longestStr, windowEnd - windowStart + 1);
                    }
                }
            }
            windowEnd++;

        }
        return longestStr;
    }
}
