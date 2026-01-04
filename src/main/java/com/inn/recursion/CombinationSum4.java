package com.inn.recursion;

/*
https://leetcode.com/problems/combination-sum-iv/
 */

import java.util.Arrays;

class Cus {
    int count;
}

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int target = 35;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        Cus cus = new Cus();
        cus.count = 0;
        backtrack(nums, target, cus);
        return cus.count;
    }

    private static void backtrack(int[] nums, int target, Cus cus){

        if(target == 0){
            cus.count++;
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=0;i<nums.length;i++){
            backtrack(nums, target-nums[i], cus);
        }
    }
}
