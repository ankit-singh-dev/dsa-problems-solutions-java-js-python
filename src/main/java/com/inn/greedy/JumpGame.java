package com.inn.greedy;

/*
https://leetcode.com/problems/jump-game/description/
 */

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    private static final Map<Integer, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        //int[] nums = {3,2,1,0,4};
        int[] nums = {2,3,1,1,4};
        //int[] nums = {1,2,3,1,1,0,2,5};
        //int[] nums = {1,2,4,1,1,0,2,5};
        System.out.println(canJumpUsingRecursion(nums));

    }

    /*
    can solve it using greedy
     */
    private static boolean canJump(int[] nums) {
        int bestMaxJump = 0;
        for(int i=0;i<nums.length;i++){
            if(i > bestMaxJump){
                return false;
            }
            int maxJump = i + nums[i];
            bestMaxJump = Math.max(bestMaxJump, maxJump);
            if(bestMaxJump >= nums.length-1){
                return true;
            }
        }
        return false;
    }

    /*
    solve it by using greedy approach
     */
    private static boolean canJumpUsingRecursion(int[] nums) {
        return helper(nums, 0);
    }

    private static boolean helper(int nums[], int currentIndex){
        if(memo.containsKey(currentIndex)){
            return memo.get(currentIndex);
        }
        System.out.println(currentIndex);

        if(currentIndex > nums.length-1){
            memo.put(currentIndex, true);
            return true;
        }else if(currentIndex == nums.length-1){
            // reached at the end
            memo.put(currentIndex, true);
            return true;
        }else if(currentIndex <= nums.length-1 && nums[currentIndex] == 0){
            memo.put(currentIndex, false);
            return false;
        }else {
            boolean[] results = new boolean[nums[currentIndex]];
            int index = 0;
            for (int j = 1; j <= nums[currentIndex]; j++) {
                // can make i jump
                results[index++] = helper(nums, currentIndex + j);
            }
            for (boolean res : results) {
                if (res) {
                    memo.put(currentIndex, true);
                    return true;
                }
            }
            memo.put(currentIndex, false);
            return false;
        }
    }
}
