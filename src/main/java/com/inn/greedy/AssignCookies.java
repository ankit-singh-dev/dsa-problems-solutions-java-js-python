package com.inn.greedy;


/*
https://leetcode.com/problems/assign-cookies/description/
https://www.geeksforgeeks.org/problems/assign-cookies/0
 */

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
    }

    private static int findContentChildren(int[] g, int[] s) {
        int greedSize = g.length;
        int cookiesSize = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;
        int right = 0;
        int count = 0;

        while (left < greedSize && right < cookiesSize){
            if(g[left] <= s[right]){
                count++;
                left++;
            }
            right++;
        }


        return count;
    }

}
