package com.inn.stacks;

/*
https://www.geeksforgeeks.org/closest-greater-or-same-value-on-left-side-for-every-element-in-array/
 */

import java.util.Arrays;

public class ClosestGreatOrSameLeft {

    public static void main(String[] args) {
        int[] array = {10, 5, 11, 6, 20, 12};
        System.out.println(Arrays.toString(bruteForceApproach(array)));
    }

    private static int[] bruteForceApproach(int[] array) {
        int len = array.length;
        int[] ans = new int[len];
        ans[0] = -1;
        for (int i = 1; i < len; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if(array[j] > array[i]){
                    // find the minimum diff
                    diff = Math.min(diff, (array[j]-array[i]));
                }
            }
            ans[i] = diff == Integer.MAX_VALUE ?  -1 :  (diff+array[i]);
        }
        return ans;
    }

}
