#include <stdlib.h>
#include <time.h>

typedef struct Node {
    int data;
    struct Node* next;
} Node;

typedef struct Queue {
    Node* front;
    Node* rear;
    int size;
} Queue;

Queue* createQueue() {
    Queue* q = (Queue*) malloc(sizeof(Queue));
    q->front = q->rear = NULL;
    q->size = 0;
    return q;
}

void enqueue(Queue* q, int data) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;

    if (q->rear == NULL) {
        q->front = q->rear = newNode;
    } else {
        q->rear->next = newNode;
        q->rear = newNode;
    }
    q->size++;
}

int dequeue(Queue* q) {
    if (q->front == NULL) {
        return -1;  // or any other error value
    }
    int data = q->front->data;
    Node* temp = q->front;
    q->front = q->front->next;
    free(temp);
    q->size--;
    return data;
}

int isEmpty(Queue* q) {
    return q->front == NULL;
}

int size(Queue* q) {
    return q->size;
}

int main() {
    Queue* q = createQueue();
    srand(time(NULL));

    // Enqueue 1000 random values
    for (int i = 0; i < 1000; i++) {
        enqueue(q, rand() % 1000);
    }

    return 0;
}