package com.inn.slidingwindow;

/*
https://leetcode.com/problems/max-consecutive-ones-iii/
 */

public class LeetCode1004 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    // using sliding window
    private static int longestOnes(int[] nums, int k) {
        int bestLen = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int kthFlip = 0;

        while (windowEnd < nums.length) {
            // expansion phase
            if (nums[windowEnd] == 0) {
                kthFlip += 1;
            }

            // shrinking phase
            while (kthFlip > k) {
                if (nums[windowStart] == 0) {
                    kthFlip -= 1;
                }
                windowStart++;
            }
            bestLen = Math.max(bestLen, windowEnd - windowStart + 1);

            windowEnd++;
        }


        return bestLen;
    }
}
