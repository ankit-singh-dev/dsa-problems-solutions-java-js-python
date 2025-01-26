package com.inn.greedy;

/*
https://leetcode.com/problems/non-overlapping-intervals/description/
 */

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {1,2},
                {1,2}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {

        Comparator<int[]> comparator = (a, b) -> b[1]-a[1];

        Arrays.sort(intervals, comparator);

        int start = intervals[0][0];
        int end = intervals[0][1];

        int removalCount = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] >= start && intervals[i][1] <= end){
                removalCount++;
            }
            start = intervals[i][0];
            end = intervals[i][1];
        }

        return removalCount;
    }
}
