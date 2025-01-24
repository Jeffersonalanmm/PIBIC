#include <stdio.h>
#include <stdlib.h>

// Define the structure for a queue node
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Define the structure for a queue
typedef struct {
    Node* front;
    Node* rear;
    int size;
} Queue;

// Function to create a new node
Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (!newNode) {
        return NULL;
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to initialize a queue
void initQueue(Queue* queue) {
    queue->front = NULL;
    queue->rear = NULL;
    queue->size = 0;
}

// Function to check if the queue is empty
int isEmpty(Queue* queue) {
    return queue->size == 0;
}

// Function to get the size of the queue
int getSize(Queue* queue) {
    return queue->size;
}

// Function to enqueue an element
void enqueue(Queue* queue, int data) {
    Node* newNode = createNode(data);
    if (queue->rear == NULL) {
        queue->front = newNode;
        queue->rear = newNode;
    } else {
        queue->rear->next = newNode;
        queue->rear = newNode;
    }
    queue->size++;
}

// Function to dequeue an element
int dequeue(Queue* queue) {
    if (isEmpty(queue)) {
        return -1; // or any other error value
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

// Function to free the queue
void freeQueue(Queue* queue) {
    while (!isEmpty(queue)) {
        dequeue(queue);
    }
}

int main() {
    Queue queue;
    initQueue(&queue);

    // Enqueue 1000 values
    for (int i = 0; i < 1000; i++) {
        enqueue(&queue, i);
    }

    // Dequeue all values
    //while (!isEmpty(&queue)) {
        //dequeue(&queue);
    //}

    freeQueue(&queue);

    return 0;
}