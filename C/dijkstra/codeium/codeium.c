#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Define the structure for a graph edge
typedef struct Edge {
    int src, dest, weight;
} Edge;

// Define the structure for a graph
typedef struct Graph {
    int V, E;
    Edge* edge;
} Graph;

// Create a graph with V vertices and E edges
Graph* createGraph(int V, int E) {
    Graph* graph = (Graph*) malloc(sizeof(Graph));
    graph->V = V;
    graph->E = E;
    graph->edge = (Edge*) malloc(E * sizeof(Edge));
    return graph;
}

// Function to find the vertex with minimum distance value
int minDistance(int* dist, int* visited, int V) {
    int min = INT_MAX, min_index;
    for (int v = 0; v < V; v++)
        if (visited[v] == 0 && dist[v] <= min)
            min = dist[v], min_index = v;
    return min_index;
}

// Function to print the shortest distances from source to all other vertices
void printSolution(int* dist, int V) {
    // Removed print statements
}

// Dijkstra's algorithm implementation
void dijkstra(Graph* graph, int src) {
    int V = graph->V;
    int* dist = (int*) malloc(V * sizeof(int));
    int* visited = (int*) malloc(V * sizeof(int));

    // Initialize distances and visited arrays
    for (int i = 0; i < V; i++)
        dist[i] = INT_MAX, visited[i] = 0;
    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, visited, V);
        visited[u] = 1;

        for (int i = 0; i < graph->E; i++) {
            int v = graph->edge[i].dest;
            int w = graph->edge[i].weight;
            if (visited[v] == 0 && dist[u] != INT_MAX && dist[u] + w < dist[v])
                dist[v] = dist[u] + w;
        }
    }

    printSolution(dist, V);

    free(dist);
    free(visited);
}

// Default main function with a 1000 values input
int main() {
    int V = 1000;
    int E = 5000; // Assuming 5 edges per vertex

    Graph* graph = createGraph(V, E);

    // Initialize edges with random weights
    for (int i = 0; i < E; i++) {
        graph->edge[i].src = rand() % V;
        graph->edge[i].dest = rand() % V;
        graph->edge[i].weight = rand() % 100;
    }

    dijkstra(graph, 0); // Run Dijkstra's algorithm from source vertex 0

    free(graph->edge);
    free(graph);

    return 0;
}