#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define V 1000  // Number of vertices

// Find the vertex with the minimum distance that hasn't been processed
int minDistance(int dist[], int processed[]) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < V; v++) {
        if (processed[v] == 0 && dist[v] <= min) {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}

// Dijkstra's algorithm for finding the shortest path
void dijkstra(int graph[V][V], int src, int dist[]) {
    int processed[V] = {0};  // Track processed vertices

    for (int i = 0; i < V; i++) {
        dist[i] = INT_MAX;
    }
    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, processed);
        processed[u] = 1;

        for (int v = 0; v < V; v++) {
            if (!processed[v] && graph[u][v] && dist[u] != INT_MAX &&
                dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }
}

// Helper function to create a random graph
void generateGraph(int graph[V][V]) {
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (i != j) {
                // Assign a random weight between 1 and 10, or 0 to indicate no edge
                graph[i][j] = rand() % 10 + 1;
            } else {
                graph[i][j] = 0;
            }
        }
    }
}

int main() {
    int graph[V][V];
    int dist[V];  // Stores the shortest distance from source

    generateGraph(graph);

    // Run Dijkstra's algorithm from vertex 0
    dijkstra(graph, 0, dist);

    // The distances array `dist` now contains shortest distances from source (vertex 0)
    return 0;
}