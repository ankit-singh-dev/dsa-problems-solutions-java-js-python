package com.inn.recursion.revision;

/*
http://leetcode.com/problems/subsets/description/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(subsets(nums));
    }


    public static List<List<Integer>> subsets(int[] nums) {

        if(nums.length ==  0){
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        int firstNo = nums[0];
        int[] restOfArray = Arrays.copyOfRange(nums, 1, nums.length);

        List<List<Integer>> result = subsets(restOfArray);

        List<List<Integer>> allResponse = new ArrayList<>();

        allResponse.addAll(result);

        for(List<Integer> no : result){
            List<Integer> temp = new ArrayList<>();
            temp.add(firstNo);
            temp.addAll(no);
            allResponse.add(temp);
        }

        return allResponse;
    }
}
