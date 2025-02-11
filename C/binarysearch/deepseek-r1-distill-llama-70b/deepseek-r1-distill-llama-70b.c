#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Comparison function for qsort
int compare(const void *a, const void *b) {
    int *x = (int *)a;
    int *y = (int *)b;
    return *x - *y;
}

// Binary Search function
int binary_search(int *array, int target, int size) {
    int low = 0;
    int high = size - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1; // Target not found
}

int main() {
    // Generate an array of 1000 random integers
    int size = 1000;
    int *array = (int *)malloc(size * sizeof(int));
    
    // Seed the random number generator
    srand(time(NULL));
    
    // Populate the array with random values
    for (int i = 0; i < size; i++) {
        array[i] = rand() % 10000; // Random numbers between 0 and 9999
    }
    
    // Sort the array
    qsort(array, size, sizeof(int), compare);
    
    // Choose a target value (in this case, the middle element)
    int target = array[size / 2];
    
    // Perform binary search
    int result = binary_search(array, target, size);
    
    // Free the allocated memory
    free(array);
    
    return result; // Return the index of the target element
}