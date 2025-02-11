#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct {
    int destination;
    int weight;
    struct Edge* next;
} Edge;

typedef struct {
    int vertices;
    Edge** adj;
} Graph;

typedef struct {
    int distance;
    int vertex;
} PriorityQueueElement;

typedef struct {
    PriorityQueueElement* elements;
    int size;
    int capacity;
} PriorityQueue;

// Function to create a new graph with given number of vertices
Graph* createGraph(int vertices) {
    Graph* graph = (Graph*) malloc(sizeof(Graph));
    graph->vertices = vertices;
    graph->adj = (Edge**) calloc(vertices, sizeof(Edge*));
    return graph;
}

// Function to add an edge to the graph
void addEdge(Graph* graph, int src, int dest, int weight) {
    Edge* newNode = (Edge*) malloc(sizeof(Edge));
    newNode->destination = dest;
    newNode->weight = weight;
    newNode->next = graph->adj[src];
    graph->adj[src] = newNode;
}

// Function to create a new priority queue
PriorityQueue* createPriorityQueue(int capacity) {
    PriorityQueue* queue = (PriorityQueue*) malloc(sizeof(PriorityQueue));
    queue->elements = (PriorityQueueElement*) malloc(sizeof(PriorityQueueElement) * capacity);
    queue->size = 0;
    queue->capacity = capacity;
    return queue;
}

// Function to swap two elements in the priority queue
void swap(PriorityQueueElement* a, PriorityQueueElement* b) {
    PriorityQueueElement temp = *a;
    *a = *b;
    *b = temp;
}

// Function to insert an element into the priority queue
void insert(PriorityQueue* queue, int distance, int vertex) {
    if (queue->size == queue->capacity) {
        printf("Priority queue is full\n");
        return;
    }

    queue->elements[queue->size].distance = distance;
    queue->elements[queue->size].vertex = vertex;
    int i = queue->size;
    queue->size++;

    // Percolate up
    while (i > 0 && queue->elements[i-1].distance > queue->elements[i].distance) {
        swap(&queue->elements[i-1], &queue->elements[i]);
        i--;
    }
}

// Function to extract the minimum element from the priority queue
PriorityQueueElement extractMin(PriorityQueue* queue) {
    if (queue->size == 0) {
        printf("Priority queue is empty\n");
        exit(EXIT_FAILURE);
    }

    PriorityQueueElement min = queue->elements[0];
    queue->size--;

    // Move last element to root and percolate down
    if (queue->size > 0) {
        queue->elements[0] = queue->elements[queue->size];
        int i = 0;
        while (2 * i + 1 < queue->size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < queue->size && queue->elements[left].distance < queue->elements[smallest].distance) {
                smallest = left;
            }
            if (right < queue->size && queue->elements[right].distance < queue->elements[smallest].distance) {
                smallest = right;
            }
            if (smallest != i) {
                swap(&queue->elements[i], &queue->elements[smallest]);
                i = smallest;
            } else {
                break;
            }
        }
    }

    return min;
}

// Function to implement Dijkstra's algorithm
void dijkstra(Graph* graph, int startVertex) {
    int* distances = (int*) calloc(graph->vertices, sizeof(int));
    distances[startVertex] = 0;

    PriorityQueue* queue = createPriorityQueue(graph->vertices);
    insert(queue, 0, startVertex);

    while (queue->size > 0) {
        PriorityQueueElement current = extractMin(queue);
        int currentVertex = current.vertex;
        int currentDistance = current.distance;

        if (currentDistance > distances[currentVertex]) {
            continue;
        }

        Edge* temp = graph->adj[currentVertex];
        while (temp != NULL) {
            int neighbor = temp->destination;
            int weight = temp->weight;

            if (distances[neighbor] > distances[currentVertex] + weight) {
                distances[neighbor] = distances[currentVertex] + weight;
                insert(queue, distances[neighbor], neighbor);
            }

            temp = temp->next;
        }
    }

    free(distances);
}

int main() {
    // Create a graph with 1000 vertices
    Graph* graph = createGraph(1000);

    // Add edges (example edges, you can modify according to your needs)
    for (int i = 0; i < 999; i++) {
        addEdge(graph, i, i + 1, 1);
    }

    // Add some random edges
    for (int i = 0; i < 1000; i++) {
        if (rand() % 2 == 0) {
            int dest = rand() % 1000;
            addEdge(graph, i, dest, rand() % 10 + 1);
        }
    }

    // Run Dijkstra's algorithm starting from vertex 0
    dijkstra(graph, 0);

    // Clean up memory
    for (int i = 0; i < 1000; i++) {
        Edge* temp = graph->adj[i];
        while (temp != NULL) {
            Edge* next = temp->next;
            free(temp);
            temp = next;
        }
    }
    free(graph->adj);
    free(graph);

    return EXIT_SUCCESS;
}