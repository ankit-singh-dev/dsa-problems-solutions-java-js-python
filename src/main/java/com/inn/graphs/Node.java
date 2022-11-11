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
public class Node {
	
	private String data;
	
	private List<Edge> edges;
	
	public Node(String data) {
		this.data = data;
		this.edges = new ArrayList<>();
	}

	public Node addNode(String data) {
		return new Node(data);
	}
	
	public Edge addEdgeToNodes(Node des,Integer weight) {
		Edge edge = new Edge(this, des, weight);
		this.edges.add(edge);
		return edge;
	}
	
	public void removeEdge(Node des) {
		this.edges.remove(new Edge(this, des, null));
	}

	public void printDetails() {
		StringBuilder builder = new StringBuilder("");
		for(Edge edge : this.edges) {
			builder.append(edge.getSrc().getData());
			builder.append("-->");
			builder.append(edge.getDes().getData());
			builder.append(":");
			builder.append(String.valueOf(edge.getWeight()));
		}
		System.out.println(builder.toString());
	}

}
