package com.inn.graphs;

/*
https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
 */

import java.util.*;

public class MinTimeToCollectAllApples {



    public static void main(String[] args) {
        
        /*
        int[][] edges = {
                {0,1},{0,2},{1,4},{1,5},{2,3},{2,6}
        };
        List<Boolean> hasApples = Arrays.asList(false,false,true,false,true,true,false);
        int n = 7;
        System.out.println(minTime(n, edges, hasApples));

         */
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }

        return dfs(0, -1, adj, hasApple);
    }

    private static int dfs(int src, int parent, Map<Integer, List<Integer>> adj,
                    List<Boolean> hasApple){

        int timeTaken = 0;

        for(int neighbour : adj.getOrDefault(src, new ArrayList<>())) {
            if(neighbour == parent) continue;
            int res = dfs(neighbour, src, adj, hasApple);

            if(res > 0 || hasApple.get(neighbour)){
                timeTaken += res + 2;
            }
        }

        return timeTaken;
    }
}
