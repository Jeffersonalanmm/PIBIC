#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

typedef struct {
    int items[MAX_SIZE];
    int front;
    int rear;
} Queue;

// Function to create an empty queue
Queue* createQueue() {
    Queue* q = (Queue*)malloc(sizeof(Queue));
    q->front = q->rear = -1;
    return q;
}

// Function to check if the queue is empty
int isEmpty(Queue* q) {
    return (q->front == -1);
}

// Function to check if the queue is full
int isFull(Queue* q) {
    return (q->rear == MAX_SIZE - 1);
}

// Function to enqueue an item into the queue
void enqueue(Queue* q, int value) {
    if (isFull(q)) {
        printf("Queue Overflow\n");
        return;
    }
    if (isEmpty(q)) {
        q->front = 0;
    }
    q->rear++;
    q->items[q->rear] = value;
}

// Function to dequeue an item from the queue
int dequeue(Queue* q) {
    if (isEmpty(q)) {
        printf("Queue Underflow\n");
        return -1;
    }
    int value = q->items[q->front];
    if (q->front == q->rear) {
        q->front = q->rear = -1;
    } else {
        q->front++;
    }
    return value;
}

int main() {
    Queue* q = createQueue();

    // Input 1000 values into the queue
    for (int i = 0; i < 1000; i++) {
        enqueue(q, i);
    }

    // Dequeue and process the values (you can add your logic here)
    while (!isEmpty(q)) {
        int value = dequeue(q);
        // Process the dequeued value
    }

    return 0;
}