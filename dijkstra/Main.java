package com.dijkstra;

public class Main {
    private static final Graph.Edge[] GRAPH = {
        new Graph.Edge("a", "b", 7),
        new Graph.Edge("a", "c", 9),
        new Graph.Edge("a", "f", 14),
        new Graph.Edge("b", "c", 10),
        new Graph.Edge("b", "d", 15),
        new Graph.Edge("c", "d", 11),
        new Graph.Edge("c", "f", 2),
        new Graph.Edge("d", "e", 6),
        new Graph.Edge("e", "f", 9),
    };
    private static final String START = "a";
    private static final String END = "e";

    public static void main(String[] args) {
        //amazonQ dijkstraAmazonq = new amazonQ();
        theAlgorithms dijkstraTheAlgorithms = new theAlgorithms();

        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        

        System.out.println("\nSolução do Rosetta:\n");
        Graph g = new Graph(GRAPH);
        g.dijkstra(START);
        g.printPath(END);
        System.out.println("\nSolução do The algorithms:\n");
        dijkstraTheAlgorithms.dijkstra(graph, 0);
        System.out.println("\nSolução do blackBox:\n");
        blackBox.dijkstra(graph, 0);
        System.out.println("\nSolução do ChatGPT:\n");
        chatGPT.dijkstra(graph, 0);
        System.out.println("\nSolução do Codeium:\n");
        codeium.dijkstra(graph, 0);
        System.out.println("\nSolução do Gemini:\n");
        googleBard.dijkstra(graph, 0); 
    }
}




