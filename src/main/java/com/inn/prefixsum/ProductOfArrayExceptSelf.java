package com.inn.prefixsum;

/*
https://leetcode.com/problems/product-of-array-except-self/description/
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {3, 4, 6, 1, 2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(betterApproach(nums)));
    }

    private static int[] betterApproach(int[] nums) {
        int len = nums.length;

        int[] leftSide = new int[len];
        int[] rightSide = new int[len];

        leftSide[0] = 1;
        for (int i = 1; i < len; i++) {
            leftSide[i] = leftSide[i - 1] * nums[i - 1];
        }

        rightSide[len - 1] = 1;
        for (int j = len - 2; j > -1; j--) {
            rightSide[j] = rightSide[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = leftSide[i] * rightSide[i];
        }

        return nums;
    }

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftSideProduct = new int[len];
        int[] rightSideProduct = new int[len];
        int[] res = new int[len];

        leftSideProduct[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftSideProduct[i] = leftSideProduct[i - 1] * nums[i];
        }

        rightSideProduct[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightSideProduct[i] = rightSideProduct[i + 1] * nums[i];
        }

        //System.out.println(Arrays.toString(leftSideProduct));
        //System.out.println(Arrays.toString(rightSideProduct));

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                res[i] = rightSideProduct[i + 1];
            } else if (i == len - 1) {
                res[i] = leftSideProduct[i - 1];
            } else {
                res[i] = leftSideProduct[i - 1] * rightSideProduct[i + 1];
            }
        }

        return res;
    }
}
