package com.inn.greedy;

public class JumpGame2 {

    public static void main(String[] args) {
        //int[] nums = {2,3,1,1,4};
        //int[] nums = {2,3,0,1,4};
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(jumpUsingRecursion(nums));
    }

    private static int jumpUsingRecursion(int[] nums) {
        return helper(nums, 0);
    }

    private static int helper(int nums[], int currentIndex){
        if(currentIndex >= nums.length-1){
            return 0;
        }else if(nums[currentIndex] == 0){
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;
        for(int jump=1;jump<=nums[currentIndex];jump++){
            int jumps = helper(nums, currentIndex + jump);
            if(jumps == Integer.MAX_VALUE){
                continue;
            }
            int totalJump = 1 + jumps;
            mini = Math.min(mini, totalJump);
        }
        return mini;
    }


}
