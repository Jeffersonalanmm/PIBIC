#include <stdio.h>
#include <stdlib.h>

#define MAX_QUEUE_SIZE 1000

typedef struct queue {
    int items[MAX_QUEUE_SIZE];
    int front;
    int rear;
} Queue;

void initialize(Queue *q) {
    q->front = -1;
    q->rear = -1;
}

int is_empty(Queue *q) {
    return q->front == -1;
}

int is_full(Queue *q) {
    return (q->rear + 1) % MAX_QUEUE_SIZE == q->front;
}

void enqueue(Queue *q, int value) {
    if (is_full(q)) {
        return;
    }
    if (q->front == -1) {
        q->front = 0;
    }
    q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
    q->items[q->rear] = value;
}

int dequeue(Queue *q) {
    if (is_empty(q)) {
        return -1;
    }
    int value = q->items[q->front];
    if (q->front == q->rear) {
        initialize(q);
    } else {
        q->front = (q->front + 1) % MAX_QUEUE_SIZE;
    }
    return value;
}

int main() {
    Queue q;
    initialize(&q);

    for (int i = 0; i < 1000; i++) {
        enqueue(&q, i);
    }

    return 0;
}