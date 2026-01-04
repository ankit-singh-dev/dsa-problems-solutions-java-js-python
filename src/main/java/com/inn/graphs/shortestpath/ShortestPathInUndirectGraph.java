package com.inn.graphs.shortestpath;

/*
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 */

import java.util.*;

public class ShortestPathInUndirectGraph {

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        int v = adj.size();
        int[] res = new int[v];

        // if source node doesn't have any neighbours
        if(adj.get(src).isEmpty()) {
            for(int i=0;i<res.length;i++){
                res[i] = i == src ? 0 : -1;
            }
            return res;
        }

        for(int i=0;i<res.length;i++){
            res[i] = -1;
        }
        boolean[] visited = new boolean[v];

        bfs(src, adj, res, visited);

        return res;
    }

    private static void bfs(int src, ArrayList<ArrayList<Integer>> adj,
                     int[] res, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        res[src] = 0;
        visited[src] = true;

        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int topNode = queue.poll();
                for(int neighbour : adj.get(topNode)){
                    if(visited[neighbour]) continue;
                    res[neighbour] = level;
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
                size--;
            }
            level++;
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(3);
        List<Integer> list2 = List.of(3);
        List<Integer> list4 = List.of(0,1);

        List<List<Integer>> adj = List.of(list1, list2, new ArrayList<>(), list4);
    }
}
