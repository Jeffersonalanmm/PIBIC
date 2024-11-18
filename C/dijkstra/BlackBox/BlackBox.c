#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define V 1000 // Number of vertices in the graph

// Function to find the vertex with the minimum distance value
int minDistance(int dist[], int sptSet[]) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < V; v++) {
        if (sptSet[v] == 0 && dist[v] <= min) {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}

// Function that implements Dijkstra's algorithm for a graph represented using an adjacency matrix
void dijkstra(int graph[V][V], int src) {
    int dist[V]; // Output array dist[i] holds the shortest distance from src to j
    int sptSet[V]; // sptSet[j] will be true if vertex j is included in the shortest path tree

    // Initialize all distances as INFINITE and sptSet[] as false
    for (int i = 0; i < V; i++) {
        dist[i] = INT_MAX;
        sptSet[i] = 0;
    }

    // Distance from source to itself is always 0
    dist[src] = 0;

    // Find the shortest path for all vertices
    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, sptSet);
        sptSet[u] = 1;

        // Update dist value of the adjacent vertices of the picked vertex
        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }
}

int main() {
    // Create a graph with 1000 vertices
    int graph[V][V];

    // Initialize the graph with some values
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (i != j) {
                graph[i][j] = rand() % 10 + 1; // Random weights between 1 and 10
            } else {
                graph[i][j] = 0; // Distance to itself is 0
            }
        }
    }

    // Run Dijkstra's algorithm from the source vertex 0
    dijkstra(graph, 0);

    return 0;
}