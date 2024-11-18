#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

typedef struct {
    int* data;
    int front;
    int rear;
    int size;
    int capacity;
} Queue;

Queue* createQueue(int capacity) {
    Queue* queue = (Queue*)malloc(sizeof(Queue));
    if (!queue) return NULL;
    
    queue->data = (int*)malloc(capacity * sizeof(int));
    if (!queue->data) {
        free(queue);
        return NULL;
    }
    
    queue->capacity = capacity;
    queue->front = 0;
    queue->rear = -1;
    queue->size = 0;
    return queue;
}

bool isEmpty(Queue* queue) {
    return (queue->size == 0);
}

bool isFull(Queue* queue) {
    return (queue->size == queue->capacity);
}

bool enqueue(Queue* queue, int value) {
    if (!queue || isFull(queue)) return false;
    
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->data[queue->rear] = value;
    queue->size++;
    return true;
}

bool dequeue(Queue* queue, int* value) {
    if (!queue || isEmpty(queue) || !value) return false;
    
    *value = queue->data[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size--;
    return true;
}

bool peek(Queue* queue, int* value) {
    if (!queue || isEmpty(queue) || !value) return false;
    
    *value = queue->data[queue->front];
    return true;
}

void destroyQueue(Queue* queue) {
    if (queue) {
        free(queue->data);
        free(queue);
    }
}

int getSize(Queue* queue) {
    return queue->size;
}

int getCapacity(Queue* queue) {
    return queue->capacity;
}

int main() {
    srand(time(NULL));
    const int QUEUE_SIZE = 2000;  // Larger than needed to handle potential overflow
    const int TEST_SIZE = 1000;
    
    Queue* queue = createQueue(QUEUE_SIZE);
    if (!queue) return 1;

    // Test array to verify results
    int* verification = (int*)malloc(TEST_SIZE * sizeof(int));
    if (!verification) {
        destroyQueue(queue);
        return 1;
    }

    // Generate and enqueue 1000 random values
    for (int i = 0; i < TEST_SIZE; i++) {
        int randomValue = rand() % 10000;  // Random values between 0 and 9999
        verification[i] = randomValue;
        if (!enqueue(queue, randomValue)) {
            free(verification);
            destroyQueue(queue);
            return 1;
        }
    }

    // Verify queue operations
    bool success = true;
    for (int i = 0; i < TEST_SIZE; i++) {
        int value;
        if (!dequeue(queue, &value) || value != verification[i]) {
            success = false;
            break;
        }
    }

    // Clean up
    free(verification);
    destroyQueue(queue);
    
    return success ? 0 : 1;
}
