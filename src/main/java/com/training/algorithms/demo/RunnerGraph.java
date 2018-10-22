package com.training.algorithms.demo;

import com.training.algorithms.datastructure.Graph;
import com.training.algorithms.datastructure.GraphTraversal;

import java.util.HashMap;
import java.util.Map;

public class RunnerGraph {

    public static void main(String... args) {
//                A
//              /   \
//             B     C
//             |  \  |
//             D --- E
//              \   /
//                F

     //saving the graph nodes into a map for reference
        Map<String, Graph<String>> graphStorage = new HashMap();
        graphStorage.put("A", new Graph("A"));
        graphStorage.put("B", new Graph("B"));
        graphStorage.put("C", new Graph("C"));
        graphStorage.put("D", new Graph("D"));
        graphStorage.put("E", new Graph("E"));
        graphStorage.put("F", new Graph("F"));

        Graph<String> root = graphStorage.get("A");
        root.addEdge(graphStorage.get("B"));
        root.addEdge(graphStorage.get("C"));

        graphStorage.get("B").addEdge(graphStorage.get("D"));
        graphStorage.get("B").addEdge(graphStorage.get("E"));

        graphStorage.get("C").addEdge(graphStorage.get("E"));

        graphStorage.get("D").addEdge(graphStorage.get("F"));
        graphStorage.get("D").addEdge(graphStorage.get("E"));

        graphStorage.get("E").addEdge(graphStorage.get("F"));

        GraphTraversal.breadthFirstTravesal(root);
    }
}
