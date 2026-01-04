package com.inn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Permutation2 {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] nums, List<Integer> currentNos, List<List<Integer>> ans) {

        if (nums.length == 0) {
            ans.add(new ArrayList<>(currentNos));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            currentNos.add(nums[i]);

            int[] firstPart = Arrays.copyOfRange(nums, 0, i);
            int[] secondPart = Arrays.copyOfRange(nums, i + 1, nums.length);
            int[] finalArray = IntStream.concat(Arrays.stream(firstPart), Arrays.stream(secondPart)).toArray();
            backtrack(finalArray, currentNos, ans);

            currentNos.remove(currentNos.size()-1);
        }

    }

}
