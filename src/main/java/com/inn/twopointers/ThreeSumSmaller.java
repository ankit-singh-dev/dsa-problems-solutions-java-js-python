package com.inn.twopointers;

/*
Given an array of n integers nums and an integer target, your task is to count the number of index triplets (i, j, k) such that:

0 <= i < j < k < n

nums[i] + nums[j] + nums[k] < target

In other words, how many unique triplets of indices produce a sum strictly less than the target.

nums = [-2, 0, 1, 3]
target = 2
o/p > 2
[-2, 0, 1] → sum = -1
[-2, 0, 3] → sum = 1
 */

import java.util.Arrays;

public class ThreeSumSmaller {

    public static void main(String[] args) {
        //int[] nums = {-2, 0, 1, 3};
        //int target = 2;

        int[] nums = {0, 0, 0, 0};
        int target = 1;
        int ans1 = threeSumSmaller(nums, target);
        int ans = threeSumSmallerBruteForce(nums, target);
        System.out.println(ans + " " + ans1);
    }

    // optimized solution
    private static int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        int len = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<len-2; i++){
            int left = i+1;
            int right = len-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target){
                    ans = ans + right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

    // using brute force
    private static int threeSumSmallerBruteForce(int[] nums, int target) {
        int ans = 0;
        int len = nums.length;
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int z=j+1; z<len; z++){
                    int sum = nums[i] + nums[j] + nums[z];
                    if(sum < target){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
