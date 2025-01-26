package com.inn.slidingwindow;

/*
https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 */

import java.util.*;

public class LeetCode2461 {

    public static void main(String[] args) {
        //int[] nums = {1, 5, 4, 2, 9, 9, 9};
        //int k = 3;

        int[] nums = {9, 9, 9, 1, 2, 3};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
        System.out.println(usingSlidingWindow(nums, k));
    }

    private static long usingSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        long bestSum = 0;
        long sum = 0;

        Map<Integer, Integer> uniqueNos = new HashMap<>(k);
        for (int i = 0; i < k; i++) {
            uniqueNos.put(nums[i], (uniqueNos.getOrDefault(nums[i], 0) + 1));
            sum += nums[i];
        }

        if (uniqueNos.size() == k) {
            bestSum = Math.max(sum, bestSum);
        }

        for (int i = 1; i < (n - k) + 1; i++) {
            int prevNo = nums[i - 1];
            int nextNo = nums[i + k - 1];

            sum = sum - prevNo;
            sum = sum + nextNo;

            uniqueNos.put(prevNo, (uniqueNos.getOrDefault(prevNo, 0) - 1));
            if(uniqueNos.get(prevNo) == 0){
                uniqueNos.remove(prevNo);
            }
            uniqueNos.put(nextNo, (uniqueNos.getOrDefault(nextNo, 0) + 1));

            if (uniqueNos.size() == k) {
                bestSum = Math.max(sum, bestSum);
            }

        }

        return bestSum;
    }

    // brute force
    private static long maximumSubarraySum(int[] nums, int k) {
        long bestSum = Long.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < (n - k) + 1; i++) {
            int sum = 0;
            Set<Integer> uniqueNos = new HashSet<>();
            for (int j = i; j < (i + k); j++) {
                if (!uniqueNos.add(nums[j])) {
                    sum = 0;
                    break;
                }
                sum += nums[j];
            }
            bestSum = Math.max(sum, bestSum);
        }

        return bestSum;
    }
}
