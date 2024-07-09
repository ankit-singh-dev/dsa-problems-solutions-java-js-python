package com.inn.recursion;

/*
https://www.youtube.com/watch?v=VaGBRiSdtFI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=33
 */

import java.util.ArrayList;
import java.util.List;

public class MazePathsWithJump {

    public static void main(String[] args) {
        List<String> allThePaths = getMazePaths(1,1,4,4);
        System.out.println(allThePaths);
        System.out.println(allThePaths.size());
    }

    private static List<String> getMazePaths(int sr, int sc, int dr, int dc){
        if((sr > dr) || (sc > dc)){
            return new ArrayList<>();
        }else if((sr == dr) && (sc == dc)){
            List<String> basePath = new ArrayList<>();
            basePath.add("");
            return basePath;
        }

        List<String> allPaths = new ArrayList<>();
        //make n vertical jumps
        for(int i=1;i<=(dr-sr);i++){
            List<String> vericalJumps = getMazePaths(sr+i, sc, dr, dc);
            for(String verticalJump : vericalJumps){
                allPaths.add("v"+i+verticalJump);
            }
        }

        //make n horizontal jumps
        for(int i=1;i<=(dc-sc);i++){
            List<String> horizontalJumps = getMazePaths(sr, sc+i, dr, dc);
            for(String horizontalJump : horizontalJumps){
                allPaths.add("h"+i+horizontalJump);
            }
        }

        //make n diagonal jumps
        for(int i=1;(i<=dr-sr) && (i<=dc-sc);i++){
            List<String> diagonalJumps = getMazePaths(sr+i, sc+i, dr, dc);
            for(String diagonalJump : diagonalJumps){
                allPaths.add("d"+i+diagonalJump);
            }
        }

        return allPaths;
    }
}
