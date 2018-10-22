package com.training.algorithms.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private T value;
    private List<Graph<T>> adjcentNodes;
    private boolean visited = false;

    public Graph(T value) {
        this.adjcentNodes = new ArrayList<>();
        this.value = value;
    }

    public void addEdge(Graph<T> graph) {
        this.adjcentNodes.add(graph);
        if (!graph.getAdjcentNodes().contains(this)) {
            graph.addEdge(this);
        }
    }

    public boolean isVisited() {
        return visited;
    }

    public void makeVisited(boolean visited) {
        this.visited = visited;
    }

    public T getValue() {
        return value;
    }

    public List<Graph<T>> getAdjcentNodes() {
        return adjcentNodes;
    }
}
