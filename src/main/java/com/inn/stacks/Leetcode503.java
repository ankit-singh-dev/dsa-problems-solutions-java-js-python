package com.inn.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode503 {

    public static void main(String[] args) {
        //int[] nums = {1,2,1};
        int[] nums = new int[]{1,2,3,4,3};
        int[] ans = bruteForceApproach(nums);
        System.out.println(Arrays.toString(ans));

        nums = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    private static int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n * 2 - 1; i >= 0; --i) {
            int j = i % n;
            while (!stk.isEmpty() && stk.peek() <= nums[j]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[j] = stk.peek();
            }
            stk.push(nums[j]);
        }
        return ans;
    }

    private static int[] bruteForceApproach(int[] nums) {
        // brute force
        int len = nums.length;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            boolean isLoopBreak = false;
            int cnt = 0;
            while(cnt < len-1){
                int temp = (j % len);
                if(nums[temp] > nums[i]){
                    ans[i] = nums[temp];
                    isLoopBreak = true;
                    break;
                }
                cnt++;
                j++;
            }
            if(!isLoopBreak){
                ans[i] = -1;
            }
        }
        return ans;
    }
}
