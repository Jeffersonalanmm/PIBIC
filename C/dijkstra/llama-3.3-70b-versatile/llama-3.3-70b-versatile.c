#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

// Define the structure for a graph
typedef struct Graph {
    int numVertices;
    int** adjMatrix;
} Graph;

// Function to create a graph with the given number of vertices
Graph* createGraph(int numVertices) {
    Graph* graph = (Graph*) malloc(sizeof(Graph));
    graph->numVertices = numVertices;
    graph->adjMatrix = (int**) malloc(numVertices * sizeof(int*));

    for (int i = 0; i < numVertices; i++) {
        graph->adjMatrix[i] = (int*) malloc(numVertices * sizeof(int));
        for (int j = 0; j < numVertices; j++) {
            graph->adjMatrix[i][j] = INT_MAX;
        }
    }

    return graph;
}

// Function to add an edge to the graph
void addEdge(Graph* graph, int src, int dest, int weight) {
    graph->adjMatrix[src][dest] = weight;
}

// Function to find the vertex with the minimum distance value
int minDistance(int* dist, int* visited, int numVertices) {
    int min = INT_MAX, minIndex;

    for (int v = 0; v < numVertices; v++) {
        if (dist[v] < min && !visited[v]) {
            min = dist[v];
            minIndex = v;
        }
    }

    return minIndex;
}

// Function to implement Dijkstra's algorithm
void dijkstra(Graph* graph, int src) {
    int* dist = (int*) malloc(graph->numVertices * sizeof(int));
    int* visited = (int*) malloc(graph->numVertices * sizeof(int));

    for (int i = 0; i < graph->numVertices; i++) {
        dist[i] = INT_MAX;
        visited[i] = 0;
    }

    dist[src] = 0;

    for (int count = 0; count < graph->numVertices - 1; count++) {
        int u = minDistance(dist, visited, graph->numVertices);

        visited[u] = 1;

        for (int v = 0; v < graph->numVertices; v++) {
            if (!visited[v] && graph->adjMatrix[u][v] != INT_MAX && dist[u] != INT_MAX && dist[u] + graph->adjMatrix[u][v] < dist[v]) {
                dist[v] = dist[u] + graph->adjMatrix[u][v];
            }
        }
    }

    free(dist);
    free(visited);
}

// Function to free the graph
void freeGraph(Graph* graph) {
    for (int i = 0; i < graph->numVertices; i++) {
        free(graph->adjMatrix[i]);
    }
    free(graph->adjMatrix);
    free(graph);
}

int main() {
    Graph* graph = createGraph(1000);

    // Add edges to the graph
    for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < 1000; j++) {
            if (i != j) {
                addEdge(graph, i, j, rand() % 100 + 1);
            }
        }
    }

    dijkstra(graph, 0);
    freeGraph(graph);

    return 0;
}