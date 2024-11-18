#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SIZE 1000

// Function to swap two elements
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to heapify a subtree rooted at index i
void heapify(int arr[], int n, int i) {
    int largest = i;          // Initialize largest as root
    int left = 2 * i + 1;      // left child
    int right = 2 * i + 2;     // right child

    // If left child is larger than root
    if (left < n && arr[left] > arr[largest])
        largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest])
        largest = right;

    // If largest is not root
    if (largest != i) {
        swap(&arr[i], &arr[largest]);
        heapify(arr, n, largest); // Recursively heapify the affected subtree
    }
}

// Main function to perform Heapsort
void heapsort(int arr[], int n) {
    // Build a maxheap
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(arr, n, i);

    // One by one extract elements from heap
    for (int i = n - 1; i > 0; i--) {
        swap(&arr[0], &arr[i]);   // Move current root to end
        heapify(arr, i, 0);        // Call heapify on the reduced heap
    }
}

int main() {
    int arr[SIZE];
    srand(time(NULL));  // Seed for random number generation

    // Generate an array with 1000 random values
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 10000;  // Values between 0 and 9999
    }

    // Perform Heapsort
    heapsort(arr, SIZE);

    return 0;
}