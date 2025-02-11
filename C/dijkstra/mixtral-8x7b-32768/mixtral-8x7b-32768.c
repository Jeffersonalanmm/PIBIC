#include <stdio.h>
#include <stdlib.h>

#define MAX_NODES 1000

typedef struct {
    int dest;
    int cost;
} Edge;

typedef struct {
    int dist;
    int visited;
} Node;

Node nodes[MAX_NODES];
Edge edges[MAX_NODES];

void dijkstra(int start) {
    int current, i, next;
    for (i = 0; i < MAX_NODES; i++) {
        nodes[i].dist = -1;
        nodes[i].visited = 0;
    }
    nodes[start].dist = 0;
    for (current = start; current >= 0; current = next) {
        next = -1;
        for (i = 0; i < MAX_NODES; i++) {
            if (!nodes[i].visited && nodes[i].dist > nodes[current].dist + edges[current].cost) {
                nodes[i].dist = nodes[current].dist + edges[current].cost;
                next = i;
            }
        }
        nodes[current].visited = 1;
    }
}

int main() {
    int i, j;
    for (i = 0; i < MAX_NODES; i++) {
        edges[i].dest = -1;
        edges[i].cost = 0;
    }
    // Input the graph here. For example:
    // edges[0].dest = 1; edges[0].cost = 1;
    // edges[1].dest = 2; edges[1].cost = 1;
    // ...
    dijkstra(0);
    return 0;
}