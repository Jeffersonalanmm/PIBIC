#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void heapify(int arr[], int size, int root) {
    int largest = root;
    int left = 2 * root + 1;
    int right = 2 * root + 2;

    if (left < size && arr[left] > arr[largest])
        largest = left;

    if (right < size && arr[right] > arr[largest])
        largest = right;

    if (largest != root) {
        swap(&arr[root], &arr[largest]);
        heapify(arr, size, largest);
    }
}

void heapSort(int arr[], int size) {
    // Build max heap
    for (int i = size / 2 - 1; i >= 0; i--)
        heapify(arr, size, i);

    // Extract elements from heap one by one
    for (int i = size - 1; i > 0; i--) {
        swap(&arr[0], &arr[i]);
        heapify(arr, i, 0);
    }
}

int isSorted(const int arr[], int size) {
    for (int i = 1; i < size; i++) {
        if (arr[i] < arr[i-1]) {
            return 0;
        }
    }
    return 1;
}

int* createRandomArray(int size, int max_value) {
    int* arr = (int*)malloc(size * sizeof(int));
    if (arr == NULL) {
        return NULL;
    }
    
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % max_value;
    }
    return arr;
}

int main() {
    const int SIZE = 1000;
    const int MAX_VALUE = 10000;
    
    // Initialize random seed
    srand((unsigned int)time(NULL));
    
    // Create and initialize random array
    int* arr = createRandomArray(SIZE, MAX_VALUE);
    if (arr == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Perform heap sort
    heapSort(arr, SIZE);

    // Verify sorting
    if (isSorted(arr, SIZE)) {
        printf("Array sorted successfully\n");
    } else {
        printf("Sorting failed\n");
    }

    // Clean up
    free(arr);
    return 0;
}
