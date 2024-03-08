package com.dijkstra;

import java.util.*;

public class gemini {

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];  // Stores shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;  // Distance of source from itself is 0
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.node;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println(src + " -> " + i + " : " + dist[i]);
        }
    }

   /*  public static void main(String[] args) {
        // Example graph
        int[][] graph = {
                {0, 4, 0, 0, 0},
                {4, 0, 8, 0, 0},
                {0, 8, 0, 7, 0},
                {0, 0, 7, 0, 9},
                {0, 0, 0, 9, 0}
        };
        int src = 0; // Source node
        dijkstra(graph, src);
    }*/
}
