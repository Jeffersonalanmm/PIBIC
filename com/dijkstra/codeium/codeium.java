package com.dijkstra;

import java.util.*;

public class codeium {
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
        pq.add(source);
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    pq.add(v);
                }
            }
        }
        
        // Print the shortest distances from the source
        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from " + source + " to " + i + " is " + dist[i]);
        }
    }
}