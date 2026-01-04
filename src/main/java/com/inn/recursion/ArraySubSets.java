package com.inn.recursion;

/*
https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.List;

public class ArraySubSets {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        //printSubSets(nums);
        anotherApproach(nums);
    }

    private static void anotherApproach(int[] nums){
        backtrack(0, nums, new ArrayList<>());
    }

    private static void backtrack(int start, int[] nums, List<Integer> output) {

        System.out.println(output);

        for(int i = start; i < nums.length; i++){

            output.add(nums[i]);
            backtrack(i+1, nums, output);

            output.remove(output.size()-1);
        }
    }

    private static void printSubSets(int[] nums){
        helper(0, nums, new ArrayList<>());
    }

    private static void helper(int idx, int[] nums, List<Integer> output){
        if(idx >= nums.length){
            System.out.println(output);
            return;
        }

        output.add(nums[idx]);
        helper(idx+1, nums, output);

        if(!output.isEmpty()) {
            output.remove(output.size() - 1);
        }
        helper(idx+1, nums, output);
    }
}
