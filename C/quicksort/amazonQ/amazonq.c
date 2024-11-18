#include <stdio.h>
#include <stdlib.h>
#include <time.h>


void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to choose median of three elements as pivot
int medianOfThree(int arr[], int low, int high) {
    int mid = low + (high - low) / 2;
    
    // Sort low, mid, high values
    if (arr[low] > arr[mid])
        swap(&arr[low], &arr[mid]);
    if (arr[low] > arr[high])
        swap(&arr[low], &arr[high]);
    if (arr[mid] > arr[high])
        swap(&arr[mid], &arr[high]);
    
    // Place pivot at high-1
    swap(&arr[mid], &arr[high - 1]);
    return arr[high - 1];
}

// Function to handle small subarrays with insertion sort
void insertionSort(int arr[], int low, int high) {
    for (int i = low + 1; i <= high; i++) {
        int key = arr[i];
        int j = i - 1;
        
        while (j >= low && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Partition function with median-of-three pivot selection
int partition(int arr[], int low, int high) {
    // Use median-of-three for pivot selection
    int pivot = medianOfThree(arr, low, high);
    int i = low;
    int j = high - 1;

    while (1) {
        while (arr[++i] < pivot) {}
        while (arr[--j] > pivot) {}
        
        if (i >= j)
            break;
        swap(&arr[i], &arr[j]);
    }
    
    swap(&arr[i], &arr[high - 1]);  // Restore pivot
    return i;
}

// Main quicksort function
void quickSort(int arr[], int low, int high) {
    // Use insertion sort for small subarrays
    if (high - low <= 15) {
        insertionSort(arr, low, high);
        return;
    }
    
    if (low < high) {
        // Get partition index
        int pi = partition(arr, low, high);
        
        // Sort elements before and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// Function to generate random array
int* generateRandomArray(int size) {
    int* arr = (int*)malloc(size * sizeof(int));
    if (!arr) return NULL;
    
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 10000;  // Random numbers between 0 and 9999
    }
    return arr;
}

int main() {
    const int SIZE = 1000;
    srand(time(NULL));  // Initialize random seed
    
    // Generate random array
    int* arr = generateRandomArray(SIZE);
    if (!arr) {
        return 1;  // Memory allocation failed
    }
    
    // Sort the array
    quickSort(arr, 0, SIZE - 1);
    
    // Clean up
    free(arr);
    return 0;
}
