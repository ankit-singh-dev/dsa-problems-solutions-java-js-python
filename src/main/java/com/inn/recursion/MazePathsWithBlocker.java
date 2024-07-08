package com.inn.recursion;

/*
https://www.geeksforgeeks.org/count-number-ways-reach-destination-maze/
 */

import java.util.ArrayList;
import java.util.List;

public class MazePathsWithBlocker {

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0}};

        List<String> allPaths = getMazePaths(1,1,4,4,maze);
        System.out.println(allPaths);
        System.out.println(allPaths.size());
    }

    private static List<String> getMazePaths(int sr, int sc, int dr, int dc, int[][] maze){
        if((sr > dr) || (sc > dc)){
            return new ArrayList<>();
        }else if((sr == dr) && (sc == dc)){
            List<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        }else if(maze[sr-1][sc-1] == -1){
            return new ArrayList<>();
        }

        // move right hand side
        List<String> rightPaths = getMazePaths(sr, sc+1, dr, dc, maze);
        // move bottom side
        List<String> bottomPaths = getMazePaths(sr+1, sc, dr, dc, maze);

        List<String> fullMazePaths = new ArrayList<>();
        for(String bottomPath : bottomPaths){
            fullMazePaths.add("b"+bottomPath);
        }
        for(String rightPath : rightPaths){
            fullMazePaths.add("r"+rightPath);
        }
        return fullMazePaths;

    }
}
