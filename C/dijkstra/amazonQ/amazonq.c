#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <stdbool.h>

#define MAX_VERTICES 100
#define INF INT_MAX

// Structure to represent a node in the adjacency list
struct Node {
    int vertex;
    int weight;
    struct Node* next;
};

// Structure to represent the graph
struct Graph {
    struct Node* adjacencyList[MAX_VERTICES];
    int numVertices;
};

// Structure for min-heap node
struct HeapNode {
    int vertex;
    int distance;
};

// Structure for min-heap
struct MinHeap {
    struct HeapNode* array;
    int size;
    int capacity;
    int* position;    // Required for decrease key
};

// Create a new graph node
struct Node* createNode(int vertex, int weight) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->vertex = vertex;
    newNode->weight = weight;
    newNode->next = NULL;
    return newNode;
}

// Initialize graph
struct Graph* createGraph(int vertices) {
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    graph->numVertices = vertices;
    
    for (int i = 0; i < vertices; i++) {
        graph->adjacencyList[i] = NULL;
    }
    
    return graph;
}

// Add edge to graph
void addEdge(struct Graph* graph, int src, int dest, int weight) {
    struct Node* newNode = createNode(dest, weight);
    newNode->next = graph->adjacencyList[src];
    graph->adjacencyList[src] = newNode;
    
    // For undirected graph, add edge in reverse direction too
    newNode = createNode(src, weight);
    newNode->next = graph->adjacencyList[dest];
    graph->adjacencyList[dest] = newNode;
}

// Create min heap
struct MinHeap* createMinHeap(int capacity) {
    struct MinHeap* minHeap = (struct MinHeap*)malloc(sizeof(struct MinHeap));
    minHeap->array = (struct HeapNode*)malloc(capacity * sizeof(struct HeapNode));
    minHeap->position = (int*)malloc(capacity * sizeof(int));
    minHeap->size = 0;
    minHeap->capacity = capacity;
    return minHeap;
}

// Swap heap nodes
void swapHeapNodes(struct HeapNode* a, struct HeapNode* b) {
    struct HeapNode temp = *a;
    *a = *b;
    *b = temp;
}

// Heapify
void minHeapify(struct MinHeap* minHeap, int idx) {
    int smallest = idx;
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;

    if (left < minHeap->size && 
        minHeap->array[left].distance < minHeap->array[smallest].distance)
        smallest = left;

    if (right < minHeap->size && 
        minHeap->array[right].distance < minHeap->array[smallest].distance)
        smallest = right;

    if (smallest != idx) {
        // Update positions
        minHeap->position[minHeap->array[smallest].vertex] = idx;
        minHeap->position[minHeap->array[idx].vertex] = smallest;
        
        // Swap nodes
        swapHeapNodes(&minHeap->array[smallest], &minHeap->array[idx]);
        minHeapify(minHeap, smallest);
    }
}

// Extract minimum node from heap
struct HeapNode extractMin(struct MinHeap* minHeap) {
    if (minHeap->size == 0) {
        struct HeapNode node = {-1, INF};
        return node;
    }

    struct HeapNode root = minHeap->array[0];
    struct HeapNode lastNode = minHeap->array[minHeap->size - 1];
    minHeap->array[0] = lastNode;

    minHeap->position[root.vertex] = minHeap->size - 1;
    minHeap->position[lastNode.vertex] = 0;

    --minHeap->size;
    minHeapify(minHeap, 0);

    return root;
}

// Decrease key value
void decreaseKey(struct MinHeap* minHeap, int vertex, int distance) {
    int i = minHeap->position[vertex];
    minHeap->array[i].distance = distance;

    while (i && minHeap->array[i].distance < 
           minHeap->array[(i - 1) / 2].distance) {
        minHeap->position[minHeap->array[i].vertex] = (i - 1) / 2;
        minHeap->position[minHeap->array[(i - 1) / 2].vertex] = i;
        swapHeapNodes(&minHeap->array[i], &minHeap->array[(i - 1) / 2]);
        i = (i - 1) / 2;
    }
}

// Dijkstra's algorithm
void dijkstra(struct Graph* graph, int src) {
    int vertices = graph->numVertices;
    int* dist = (int*)malloc(vertices * sizeof(int));
    int* parent = (int*)malloc(vertices * sizeof(int));
    
    struct MinHeap* minHeap = createMinHeap(vertices);
    
    // Initialize distances and min heap
    for (int v = 0; v < vertices; v++) {
        dist[v] = INF;
        parent[v] = -1;
        minHeap->array[v].vertex = v;
        minHeap->array[v].distance = INF;
        minHeap->position[v] = v;
    }

    // Distance to source is 0
    minHeap->array[src].distance = 0;
    dist[src] = 0;
    decreaseKey(minHeap, src, dist[src]);
    minHeap->size = vertices;

    // Process vertices
    while (minHeap->size > 0) {
        struct HeapNode node = extractMin(minHeap);
        int u = node.vertex;

        struct Node* pCrawl = graph->adjacencyList[u];
        while (pCrawl != NULL) {
            int v = pCrawl->vertex;

            if (minHeap->position[v] < minHeap->size && 
                dist[u] != INF && 
                pCrawl->weight + dist[u] < dist[v]) {
                dist[v] = dist[u] + pCrawl->weight;
                parent[v] = u;
                decreaseKey(minHeap, v, dist[v]);
            }
            pCrawl = pCrawl->next;
        }
    }

    // Print the shortest path tree
    printf("Vertex\tDistance from Source\tPath\n");
    for (int i = 0; i < vertices; i++) {
        printf("%d\t%d\t\t\t", i, dist[i]);
        
        // Print path
        int j = i;
        while (parent[j] != -1) {
            printf("%d <- ", j);
            j = parent[j];
        }
        if (i != src)
            printf("%d", src);
        printf("\n");
    }

    free(dist);
    free(parent);
    free(minHeap->array);
    free(minHeap->position);
    free(minHeap);
}

// Example usage
int main() {
    int vertices = 9;
    struct Graph* graph = createGraph(vertices);

    // Add edges
    addEdge(graph, 0, 1, 4);
    addEdge(graph, 0, 7, 8);
    addEdge(graph, 1, 2, 8);
    addEdge(graph, 1, 7, 11);
    addEdge(graph, 2, 3, 7);
    addEdge(graph, 2, 8, 2);
    addEdge(graph, 2, 5, 4);
    addEdge(graph, 3, 4, 9);
    addEdge(graph, 3, 5, 14);
    addEdge(graph, 4, 5, 10);
    addEdge(graph, 5, 6, 2);
    addEdge(graph, 6, 7, 1);
    addEdge(graph, 6, 8, 6);
    addEdge(graph, 7, 8, 7);

    dijkstra(graph, 0);

    return 0;
}
