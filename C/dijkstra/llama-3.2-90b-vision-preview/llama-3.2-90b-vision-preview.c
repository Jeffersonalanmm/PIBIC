#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Define the number of vertices in the graph
#define V 1000

// Function to find the vertex with the minimum distance value
int minDistance(int dist[], int sptSet[]) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < V; v++)
        if (dist[v] < min && sptSet[v] == 0)
            min = dist[v], min_index = v;

    return min_index;
}

// Function to implement Dijkstra's algorithm
void dijkstra(int graph[V][V], int src) {
    int dist[V];
    int sptSet[V];

    // Initialize distances and shortest path tree set
    for (int i = 0; i < V; i++)
        dist[i] = INT_MAX, sptSet[i] = 0;

    // Distance of source node from itself is 0
    dist[src] = 0;

    // Find shortest path for all vertices
    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, sptSet);

        // Mark the picked vertex as processed
        sptSet[u] = 1;

        // Update dist value of the adjacent vertices of the picked vertex
        for (int v = 0; v < V; v++)
            if (graph[u][v] > 0 && sptSet[v] == 0 && dist[v] > dist[u] + graph[u][v])
                dist[v] = dist[u] + graph[u][v];
    }
}

// Function to generate a random graph
void generateGraph(int graph[V][V]) {
    for (int i = 0; i < V; i++)
        for (int j = 0; j < V; j++)
            graph[i][j] = (rand() % 2) ? (rand() % 10) : 0;
}

int main() {
    int graph[V][V];

    // Generate a random graph
    generateGraph(graph);

    // Run Dijkstra's algorithm
    dijkstra(graph, 0);

    return 0;
}