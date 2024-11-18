#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 1000

typedef struct {
    int items[MAX_SIZE];
    int front;
    int rear;
} Queue;

void initializeQueue(Queue *queue) {
    queue->front = queue->rear = -1;
}

int isEmpty(Queue *queue) {
    return queue->front == -1;
}

int isFull(Queue *queue) {
    return (queue->rear + 1) % MAX_SIZE == queue->front;
}

void enqueue(Queue *queue, int item) {
    if (isFull(queue)) {
        // Handle queue overflow (e.g., resize or error)
        return;
    }

    if (isEmpty(queue)) {
        queue->front = queue->rear = 0;
    } else {
        queue->rear = (queue->rear + 1) % MAX_SIZE;
    }

    queue->items[queue->rear] = item;
}

int dequeue(Queue *queue) {
    if (isEmpty(queue)) {
        // Handle queue underflow (e.g., return error or default value)
        return -1;
    }

    int item = queue->items[queue->front];

    if (queue->front == queue->rear) {
        initializeQueue(queue);
    } else {
        queue->front = (queue->front + 1) % MAX_SIZE;
    }

    return item;
}

int main() {
    Queue queue;
    initializeQueue(&queue);

    // Enqueue 1000 values
    for (int i = 0; i < 1000; i++) {
        enqueue(&queue, i);
    }

    // Dequeue and print all values
    while (!isEmpty(&queue)) {
        int item = dequeue(&queue);
        // You can process the dequeued item here
    }

    return 0;
}