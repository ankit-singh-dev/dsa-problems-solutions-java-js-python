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

        //make n vertical jumps
        List<String> vericalJumps = new ArrayList<>();
        for(int i=1;i<4;i++){
            vericalJumps = getMazePaths(sr+i, sc, dr, dc);
        }

        //make n horizontal jumps
        List<String> horizontalJumps = new ArrayList<>();
        for(int i=1;i<4;i++){
            horizontalJumps = getMazePaths(sr, sc+i, dr, dc);
        }

        //make n diagonal jumps
        List<String> diagonalJumps = new ArrayList<>();
        for(int i=1;i<4;i++){
            diagonalJumps = getMazePaths(sr+i, sc+i, dr, dc);
        }

        List<String> allPaths = new ArrayList<>();
        for(String verticalJump : vericalJumps){
            allPaths.add("v"+verticalJump);
        }

        for(String horizontalJump : horizontalJumps){
            allPaths.add("h"+horizontalJump);
        }

        for(String diagonalJump : diagonalJumps){
            allPaths.add("d"+diagonalJump);
        }
        return allPaths;
    }
}
