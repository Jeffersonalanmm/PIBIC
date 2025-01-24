#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to swap two elements
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to perform bubble sort
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        // Flag to check if any swaps were made in the current pass
        int swapped = 0;

        for (int j = 0; j < n - i - 1; j++) {
            // If the current element is greater than the next element, swap them
            if (arr[j] > arr[j + 1]) {
                swap(&arr[j], &arr[j + 1]);
                swapped = 1;
            }
        }

        // If no swaps were made in the current pass, the list is already sorted
        if (!swapped) {
            break;
        }
    }
}

// Function to generate a random array of integers
void generateRandomArray(int arr[], int n) {
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }
}

int main() {
    const int n = 1000;
    int arr[n];

    // Generate a random array of 1000 integers
    generateRandomArray(arr, n);

    // Perform bubble sort on the array
    bubbleSort(arr, n);

    return 0;
}