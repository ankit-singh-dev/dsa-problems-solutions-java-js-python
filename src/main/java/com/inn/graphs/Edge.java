package com.inn.graphs;

import java.util.Objects;

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
public class Edge {
	
	private Node src;
	private Node des;
	private Integer weight;
	
	public Edge addEdge(Node src,Node des, Integer weight) {
		return new Edge(src,des,weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(des, src);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		return (this.src.getData().equalsIgnoreCase(other.getSrc().getData()) && this.des.getData().equalsIgnoreCase(other.getDes().getData()));
	}

}
