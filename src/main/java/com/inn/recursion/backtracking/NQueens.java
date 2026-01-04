package com.inn.recursion.backtracking;

/*
Place n queen in N*N grid such that following conditions is met
i) No two queens at the same row
ii) No two queens at the same column
 */

import java.util.Arrays;

public class NQueens {

    public static void main(String[] args) {
        boolean[][] grid = new boolean[3][3];
        nQueens(grid, 0);
    }

    private static void nQueens(boolean[][] grid, int row) {
        // base case
        if(row == grid.length){
            for (boolean[] layout :  grid){
                System.out.println(Arrays.toString(layout));
            }
            System.out.println("----------");
            return;
        }

        for(int col = 0;col < grid[row].length; col++){
            if(isSafe(grid, row, col)){
                grid[row][col] = true;
                nQueens(grid, row+1);
                grid[row][col] = false;
            }
        }

    }

    private static boolean isSafe(boolean[][] grid, int row, int col) {

        // check for row wise
        for (int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
            if (grid[row][rowIdx]) {
                return false;
            }
        }

        // check for column wise
        for (int colIdx = 0; colIdx < grid.length; colIdx++) {
            if (grid[colIdx][col]) {
                return false;
            }
        }

        return true;
    }
}
