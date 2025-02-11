#include <stdlib.h>
#include <stdio.h>

// Define structure for queue node
typedef struct Node {
    int data;
    struct Node* next;
} Node;

// Define structure for queue
typedef struct {
    Node* front;
    Node* rear;
    int size;
} Queue;

// Function to create a new queue
Queue* createQueue() {
    Queue* q = (Queue*)malloc(sizeof(Queue));
    q->front = NULL;
    q->rear = NULL;
    q->size = 0;
    return q;
}

// Function to add an element to the queue
void enqueue(Queue* q, int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = value;
    newNode->next = NULL;

    if (q->rear == NULL) {
        q->front = newNode;
        q->rear = newNode;
    } else {
        q->rear->next = newNode;
        q->rear = newNode;
    }
    q->size++;
}

// Function to remove an element from the queue
int dequeue(Queue* q) {
    if (q->front == NULL) {
        return -1; // Indicate error: queue is empty
    }

    Node* temp = q->front;
    int value = temp->data;
    q->front = temp->next;

    if (q->front == NULL) {
        q->rear = NULL;
    }

    free(temp);
    q->size--;
    return value;
}

// Function to check if the queue is empty
int isEmpty(Queue* q) {
    return (q->front == NULL);
}

// Function to get the size of the queue
int queueSize(Queue* q) {
    return q->size;
}

int main() {
    // Create a queue
    Queue* q = createQueue();

    // Enqueue 1000 values (0 to 999)
    for (int i = 0; i < 1000; i++) {
        enqueue(q, i);
    }

    // Dequeue all values and store them in an array
    int* result = (int*)malloc(1000 * sizeof(int));
    for (int i = 0; i < 1000; i++) {
        result[i] = dequeue(q);
    }

    // Verify the sum of dequeued values
    int sum = 0;
    for (int i = 0; i < 1000; i++) {
        sum += result[i];
    }

    // Free allocated memory
    free(result);

    return 0;
}