package com.inn.sortingsearching;

/*
https://leetcode.com/problems/search-a-2d-matrix/
 */

public class LeetCode74 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int start = 0;
        int end = (rowLen * colLen) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / colLen;
            int col = mid % colLen;
            if (matrix[row][col] == target) {
                return true;
            } else if (target > matrix[row][col]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;


    }
}
