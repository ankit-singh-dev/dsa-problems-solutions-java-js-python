package com.inn.slidingwindow;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */

public class LeetCode209 {

    public static void main(String[] args) {
        //int[] nums = {2, 3, 1, 2, 4, 3};
        //int target = 7;

        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;

        System.out.println(minSubArrayLen(target, nums));
        System.out.println(usingSlidingWindow(target, nums));
    }

    private static int usingSlidingWindow(int target, int[] nums) {
        int minLen = nums.length + 1;
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0; // 1
        while (windowEnd < nums.length) {
            // expansion
            sum += nums[windowEnd];
            if (sum >= target) {
               minLen = Math.min(windowEnd-windowStart+1, minLen);
               // shrinking
                while(sum >= target && windowStart < windowEnd){
                    sum -= nums[windowStart];
                    windowStart++;
                    if(sum >= target) {
                        minLen = Math.min(windowEnd - windowStart + 1, minLen);
                    }
                }
            }
            windowEnd++;
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int bestLen = len + 1;

        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum >= target) {
                    bestLen = Math.min(j - i + 1, bestLen);
                    break;
                }
            }
        }

        return bestLen == len + 1 ? 0 : bestLen;
    }
}
