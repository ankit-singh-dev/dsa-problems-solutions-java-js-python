package com.inn.recursion;

/*
https://leetcode.com/problems/combination-sum-ii/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
        System.out.println(anotherApproach(candidates, target));
    }

    private static List<List<Integer>> anotherApproach(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> allComb = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<>(), allComb);
        return allComb;
    }

    private static void backtrack(int start, int target, int[] candidates, List<Integer> current, List<List<Integer>> allComb) {

        // base case
        if (target == 0) {
            allComb.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }


        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, current, allComb);

            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> allComb = new ArrayList<>();
        helper(0, target, candidates, new ArrayList<>(), allComb);
        return allComb;
    }

    private static void helper(int idx, int target, int[] candidates, List<Integer> current,
                               List<List<Integer>> allComb) {

        if (target == 0) {
            allComb.add(new ArrayList(current));
            return;
        }
        if (target < 0 || idx == candidates.length) {
            return;
        }

        current.add(candidates[idx]);
        helper(idx + 1, target - candidates[idx], candidates, current, allComb);

        current.remove(current.size() - 1);
        while (idx + 1 < candidates.length && candidates[idx] == candidates[idx + 1]) {
            idx++;
        }
        helper(idx + 1, target, candidates, current, allComb);
    }
}
