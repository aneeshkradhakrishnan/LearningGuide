package com.training.algorithms.datastructure;

import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class GraphTraversal {
    public static <T> void depthFirstTravesal(Graph<T> graph) {
        Stack<Graph> stack = new Stack();
        stack.add(graph);
        graph.makeVisited(true);
        while (!stack.isEmpty()) {
            Graph<T> element = stack.pop();
            System.out.print(element.getValue().toString() + " ");

            List<Graph<T>> neighbours = element.getAdjcentNodes();
            for (int i = 0; i < neighbours.size(); i++) {
                Graph<T> n = neighbours.get(i);
                if (n != null && !n.isVisited()) {
                    stack.add(n);
                    n.makeVisited(true);

                }
            }
        }
    }

    /**
     * Recursive
     * @param graph
     * @param <T>
     */
    public static <T> void dfs(Graph<T> graph) {
        System.out.print(graph.getValue() + " ");
        List<Graph<T>> neighbours=graph.getAdjcentNodes();
        graph.makeVisited(true);
        for (int i = 0; i < neighbours.size(); i++) {
            Graph<T> n=neighbours.get(i);
            if(n!=null && !n.isVisited())
            {
                dfs(n);
            }
        }
    }

    /**
     * Recursive
     * @param graph
     * @param <T>
     */
    public static <T> void bfs(Graph<T> graph) {
        Queue<Graph<T>> queue = new LinkedList();
        queue.add(graph);
        bfs(queue);
    }

    private static <T> void bfs(Queue<Graph<T>> queue) {
        if (!queue.isEmpty()) {
            Graph<T> element = queue.poll();
            element.makeVisited(true);
            System.out.print(element.getValue().toString() + " ");

            for(Graph<T> adjacent: element.getAdjcentNodes()) {
                if(!adjacent.isVisited()) {
                    adjacent.makeVisited(true);
                    queue.add(adjacent);
                }
            }
            bfs(queue);
        }
    }

    public static <T> void breadthFirstTravesal(Graph<T> graph) {
        Queue<Graph> queue = new LinkedList<>();
        queue.add(graph);
        graph.makeVisited(true);
        while (!queue.isEmpty()) {
            Graph<T> element = queue.poll();
            System.out.print(element.getValue().toString() + " ");

            List<Graph<T>> neighbours = element.getAdjcentNodes();
            for (int i = 0; i < neighbours.size(); i++) {
                Graph<T> n = neighbours.get(i);
                if (n != null && !n.isVisited()) {
                    queue.add(n);
                    n.makeVisited(true);
                }
            }
        }
    }
}
