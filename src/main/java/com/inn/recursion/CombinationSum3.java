package com.inn.recursion;

/*
https://leetcode.com/problems/combination-sum-iii/
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {
        int n = 7, k = 3;
        System.out.println(combinationSum3(n, k));
        System.out.println(anotherApproach(n, k));
    }

    private static List<List<Integer>> anotherApproach(int n, int k) {
        List<List<Integer>> allComb = new ArrayList<>();
        backtrack1(1, n, k, new ArrayList<>(), allComb);
        return allComb;
    }

    private static void backtrack1(int start, int n, int k, List<Integer> current, List<List<Integer>> allComb) {

        if (k == 0) {
            if (n == 0) {
                allComb.add(new ArrayList<>(current));
            }
            return;
        }

        for (int idx = start; idx <= 9; idx++) {
            current.add(idx);
            backtrack1(idx + 1, n - idx, k - 1, current, allComb);

            current.remove(current.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum3(int n, int k) {
        List<List<Integer>> allList = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), allList);
        return allList;
    }

    private static void backtrack(int start, int n, int k, List<Integer> current,
                                  List<List<Integer>> allList) {

        if (k == 0) {
            if (n == 0) {
                allList.add(new ArrayList(current));
            }
            return;
        }

        if (start > 9) {
            return;
        }

        current.add(start);
        backtrack(start + 1, n - start, k - 1, current, allList);

        current.remove(current.size() - 1);
        backtrack(start + 1, n, k, current, allList);
    }
}
