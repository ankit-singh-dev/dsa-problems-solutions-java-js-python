package com.inn.recursion;

/*
https://www.geeksforgeeks.org/problems/subset-sums2234/1
 */

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(subsetSums(arr));
    }

    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> sumSubsets = new ArrayList<>();
        addSubSets(0, arr, new ArrayList<>(), sumSubsets, 0);
        return sumSubsets;
    }

    private static void addSubSets(int start, int[] array, List<Integer> subSets, List<Integer> sumSubsets, int sum) {

        if (start == array.length) {
            sumSubsets.add(sum);
            return;
        }

        subSets.add(array[start]);
        addSubSets(start + 1, array, subSets, sumSubsets, sum + array[start]);

        subSets.remove(subSets.size() - 1);
        addSubSets(start + 1, array, subSets, sumSubsets, sum);
    }
}
