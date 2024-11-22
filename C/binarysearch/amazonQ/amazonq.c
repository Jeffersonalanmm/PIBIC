#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to compare two integers for qsort
int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

// Binary search function
int binarySearch(int arr[], int size, int target) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid; // Found target
        } else if (arr[mid] < target) {
            left = mid + 1; // Search in the right half
        } else {
            right = mid - 1; // Search in the left half
        }
    }
    return -1; // Target not found
}

int main() {
    int size = 1000;
    int arr[size];
    int target;

    // Seed random number generator
    srand(time(NULL));

    // Generate random values and fill the array
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 10000; // Random numbers between 0 and 9999
    }

    // Sort the array
    qsort(arr, size, sizeof(int), compare);

    // Pick a random target
    target = rand() % 10000;

    // Perform binary search
    int result = binarySearch(arr, size, target);

    // The result can be used further if needed, but no output is printed
   
}