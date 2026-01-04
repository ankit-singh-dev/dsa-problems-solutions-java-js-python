package com.inn.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBasic {

    // uses to store graph nodes with edges without weight
    final Map<String, List<String>> adjancyList;

    public GraphBasic(){
        this.adjancyList = new HashMap<>();
    }

    public boolean addNodes(String node){
        adjancyList.putIfAbsent(node, new ArrayList<>());
        return true;
    }

    public void addEdgeWithoutWeight(String source, String destination, boolean isDirected) {
        adjancyList.putIfAbsent(source, new ArrayList<>());
        adjancyList.putIfAbsent(destination, new ArrayList<>());

        adjancyList.get(source).add(destination);
        if(!isDirected){
            adjancyList.get(destination).add(source);
        }
    }

    public void printGraph() {
        for (String vertex : adjancyList.keySet()){
            System.out.println(vertex + "->" + adjancyList.get(vertex));
        }
    }


    public static void main(String[] args) {
        GraphBasic graphBasic = new GraphBasic();
        graphBasic.addNodes("A");
        graphBasic.addNodes("B");
        graphBasic.addNodes("C");
        graphBasic.addNodes("D");

        graphBasic.addEdgeWithoutWeight("A", "B", true);
        graphBasic.addEdgeWithoutWeight("B", "C", true);
        graphBasic.addEdgeWithoutWeight("C", "D", true);

        graphBasic.printGraph();

    }
}
