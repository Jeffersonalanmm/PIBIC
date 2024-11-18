#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

typedef struct {
    int items[MAX_SIZE];
    int front;
    int rear;
} Queue;

// Initialize queue
void initializeQueue(Queue* q) {
    q->front = -1;
    q->rear = -1;
}

// Check if the queue is empty
int isEmpty(Queue* q) {
    return (q->front == -1 && q->rear == -1);
}

// Check if the queue is full
int isFull(Queue* q) {
    return (q->rear == MAX_SIZE - 1);
}

// Enqueue function
void enqueue(Queue* q, int value) {
    if (isFull(q)) {
        return;  // Queue is full
    }
    if (isEmpty(q)) {
        q->front = 0;
    }
    q->items[++q->rear] = value;
}

// Dequeue function
int dequeue(Queue* q) {
    if (isEmpty(q)) {
        return -1;  // Queue is empty
    }
    int dequeuedValue = q->items[q->front];
    if (q->front == q->rear) {
        // Queue is now empty
        q->front = q->rear = -1;
    } else {
        q->front++;
    }
    return dequeuedValue;
}

// Peek function
int peek(Queue* q) {
    if (isEmpty(q)) {
        return -1;  // Queue is empty
    }
    return q->items[q->front];
}

int main() {
    Queue q;
    initializeQueue(&q);

    // Enqueue 1000 values
    for (int i = 0; i < 1000; i++) {
        enqueue(&q, i);
    }

    // Dequeue all values to simulate typical usage
    for (int i = 0; i < 1000; i++) {
        dequeue(&q);
    }

    return 0;
}
