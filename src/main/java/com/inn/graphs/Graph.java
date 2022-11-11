package com.inn.graphs;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graph {
	
	private List<Node> nodes;
	private boolean isDirected;
	private boolean isWeighted;
	
	public Graph(boolean isDirected, boolean isWeighted) {
		super();
		this.nodes = new ArrayList<>();
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
	}

	public Node addNode(String data) {
		Node newNode = new Node(data);
		this.nodes.add(newNode);
		return newNode;
	}
	
	public void addEdges(Node src,Node des,Integer weight) {
		if(!this.isWeighted) {
			weight = null;
		}
		src.addEdgeToNodes(des, weight);
		if(!this.isDirected) {
			des.addEdgeToNodes(src, weight);
		}
	}
	
	public void removeEdge(Node src,Node des) {
		src.removeEdge(des);
		if(!this.isDirected) {
			des.removeEdge(src);
		}
	}
	
	public void print() {
		for(Node node : this.nodes) {
			node.printDetails();
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(true, true);
		Node patNode = graph.addNode("Patna");
		Node muzNode = graph.addNode("Muzafarpur");
		Node sahebGanjNode = graph.addNode("Sahebganj");
		
		graph.addEdges(patNode, muzNode, 50);
		graph.addEdges(patNode, sahebGanjNode, 80);
		graph.addEdges(muzNode, sahebGanjNode, 20);
		
		graph.print();
	}

}
