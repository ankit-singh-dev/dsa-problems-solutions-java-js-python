package com.inn.arrays;

/*
https://leetcode.com/problems/rotate-array/
https://takeuforward.org/data-structure/rotate-array-by-k-elements/
https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 */

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        /*
        right rotate array with k steps
         */

        rotateUsingExtraSpace(nums, k);
        //rotate(nums, k);

        usingReversalAlgo(nums, k);

        System.out.println(Arrays.toString(nums));
    }

    private static void usingReversalAlgo(int[] nums, int k){
        int len = nums.length;

        int updatedK = k % len;

        if(updatedK == 0){
            return;
        }

        //reverse whole array (0 to len-1)
        reverse(0, len-1, nums);

        // reverse first k elements
        reverse(0, updatedK-1, nums);

        // reverse remaining n-k elements
        reverse(updatedK, len-1, nums);
    }

    private static void reverse(int start, int end, int[] nums){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }


    private static void rotate(int[] nums, int k) {
        int len = nums.length;

        int kCopy = k % len;

        while(kCopy > 0){
            int temp = nums[len-1];
            for(int i=len-2;i>=0;i--){
                nums[i+1] = nums[i];
            }
            nums[0] = temp;
            kCopy--;
        }

        System.out.println(Arrays.toString(nums));

    }

    // using extra space
    private static void rotateUsingExtraSpace(int[] nums, int k) {
        int len = nums.length;
        int[] newArray = new int[len];

        int modifiedK = k % len;
        int divPoint = len-modifiedK;

        int index = 0;
        for(int i=divPoint;i<len;i++){
            newArray[index++] = nums[i];
        }

        for(int i=0;i<divPoint;i++){
            newArray[index++] = nums[i];
        }

        System.out.println(Arrays.toString(newArray));

    }
}
