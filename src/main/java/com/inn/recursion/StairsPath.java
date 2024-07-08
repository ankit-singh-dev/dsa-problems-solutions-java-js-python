package com.inn.recursion;

/*
https://www.youtube.com/watch?v=hMJAlbJIS7E&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=29
 */

import java.util.ArrayList;
import java.util.List;

public class StairsPath {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(getStairsPath(n));
    }

    private static List<String> getStairsPath(int n){
        if(n == 1){
            List<String> basePath = new ArrayList<>();
            basePath.add("1");
            return basePath;
        }else if(n < 0){
            return new ArrayList<>();
        }

        final List<String> stairsPath1 = getStairsPath(n-1);
        final List<String> stairsPath2 = getStairsPath(n-2);
        final List<String> stairsPath3 = getStairsPath(n-3);

        final List<String> finalStairsPath = new ArrayList<>();
        for(String path1 : stairsPath1){
            finalStairsPath.add("1" + path1);
        }
        for(String path2 : stairsPath2){
            finalStairsPath.add("2" + path2);
        }
        for(String path3 : stairsPath3){
            finalStairsPath.add("3" + path3);
        }
        return finalStairsPath;
    }
}
