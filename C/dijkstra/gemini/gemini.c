#include <stdio.h>
#include <limits.h>
#include <stdbool.h>

#define V 1000

int minDistance(int dist[], bool sptSet[]) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < V; v++)
        if (sptSet[v] == false && dist[v] <= min)
            min = dist[v], min_index = v;

    return min_index;
}

void dijkstra(int graph[V][V], int src) {
    int dist[V];
    bool sptSet[V];

    for (int i = 0; i < V; i++)
        dist[i] = INT_MAX, sptSet[i] = false;

    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, sptSet);

        sptSet[u] = true;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
    }
}

int main() {
    int graph[V][V];

    // Populate the graph with 1000x1000 values (replace with actual values)
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (i != j) {
                graph[i][j] = rand() % 10 + 1; // Random weights between 1 and 10
            } else {
                graph[i][j] = 0; // Distance to itself is 0
            }
        }
    }

    int src = 0;  // Source vertex

    dijkstra(graph, src);

    return 0;
}