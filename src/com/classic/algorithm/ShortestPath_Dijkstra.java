package com.classic.algorithm;

import java.util.List;
import java.util.Queue;

public class ShortestPath_Dijkstra {

}

class Vertex{
	int val;
}

class Graph {
	private List<Vertex> vertexs;
	private int[][] edges;
	private Queue<Vertex> unVisited;
	
	public void search() {
		while (!unVisited.isEmpty()) {
			Vertex vex = unVisited.element();
		}
	}
}