package com.inn.recursion;

/*
https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=perfect-sum-problem
 */

import java.util.ArrayList;
import java.util.List;

public class SubSetsWithSumK {

    public static void main(String[] args) {
        int[] nums = {28,4,3,27,0,24,26};
        int target = 24;
        printSubSetsWithSumK(0, nums, target, 0, new ArrayList<>());
        System.out.println(perfectSum(nums, target));
    }

    private static int perfectSum(int[] nums, int target){
        helper(0, nums, target, 0);
        return count;
    }

    static int count = 0;

    private static void helper(int idx, int[] nums, int target, int sum){
        if(idx >= nums.length){
            if(sum == target){
                count++;
            }
            return;
        }
        sum = sum + nums[idx];
        helper(idx+1, nums, target, sum);
        sum = sum - nums[idx];
        helper(idx+1, nums, target, sum);
    }

    private static void printSubSetsWithSumK(int idx, int[] nums, int target, int sum, List<Integer> list){

        if(idx >= nums.length){
            if(sum == target){
                System.out.println(list);
            }
            return;
        }
        list.add(nums[idx]);
        sum = sum + nums[idx];
        printSubSetsWithSumK(idx+1, nums, target, sum , list);

        if(!list.isEmpty()) {
            list.remove(list.size() - 1);
        }
        sum = sum-nums[idx];
        printSubSetsWithSumK(idx+1, nums, target, sum, list);
    }
}
