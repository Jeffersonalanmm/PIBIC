#include <stdio.h>
#include <stdlib.h>

// Define the structure for a queue node
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Define the structure for a queue
typedef struct Queue {
    Node* front;
    Node* rear;
    int size;
} Queue;

// Function to create a new queue node
Node* createNode(int data) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    if (!newNode) {
        printf("Memory error\n");
        return NULL;
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to create a new queue
Queue* createQueue() {
    Queue* queue = (Queue*) malloc(sizeof(Queue));
    if (!queue) {
        // printf("Memory error\n");
        return NULL;
    }
    queue->front = NULL;
    queue->rear = NULL;
    queue->size = 0;
    return queue;
}

// Function to check if the queue is empty
int isEmpty(Queue* queue) {
    return queue->size == 0;
}

// Function to add an element to the queue
void enqueue(Queue* queue, int data) {
    Node* newNode = createNode(data);
    if (queue->rear) {
        queue->rear->next = newNode;
        queue->rear = newNode;
    } else {
        queue->front = newNode;
        queue->rear = newNode;
    }
    queue->size++;
}

// Function to remove an element from the queue
int dequeue(Queue* queue) {
    if (isEmpty(queue)) {
        // printf("Queue is empty\n");
        return -1; // Return -1 to indicate an error
    }
    int data = queue->front->data;
    Node* temp = queue->front;
    queue->front = queue->front->next;
    if (queue->front == NULL) {
        queue->rear = NULL;
    }
    free(temp);
    queue->size--;
    return data;
}

// Function to get the front element of the queue
int front(Queue* queue) {
    if (isEmpty(queue)) {
        // printf("Queue is empty\n");
        return -1; // Return -1 to indicate an error
    }
    return queue->front->data;
}

// Function to get the size of the queue
int size(Queue* queue) {
    return queue->size;
}

int main() {
    Queue* queue = createQueue();
    for (int i = 0; i < 1000; i++) {
        enqueue(queue, i);
    }
    //for (int i = 0; i < 1000; i++) {
      //  dequeue(queue);
    //}
    return 0;
}