package com.inn.recursion;

/*
https://www.youtube.com/watch?v=7i41gZLXe5k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=31
 */

import java.util.ArrayList;
import java.util.List;

public class MazePaths {

    public static void main(String[] args) {
        List<String> allThePaths = getMazePaths(1,1,3,2);
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
        List<String> moveVertically = getMazePaths(sr+1, sc, dr, dc);
        List<String> moveHorizontally = getMazePaths(sr, sc+1, dr, dc);

        List<String> fullMazePaths = new ArrayList<>();
        for(String vertically : moveVertically){
            fullMazePaths.add("v"+vertically);
        }
        for(String horizontally : moveHorizontally){
            fullMazePaths.add("h"+horizontally);
        }
        return fullMazePaths;
    }
}
