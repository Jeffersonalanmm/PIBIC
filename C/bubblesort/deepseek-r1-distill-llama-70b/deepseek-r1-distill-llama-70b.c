#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to swap two integers
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to perform Bubble Sort
void bubbleSort(int array[], int size) {
    int i;
    for (i = 0; i < size - 1; i++) {
        // Create a flag that will allow the function to terminate early if there's nothing left to sort
        int swapped = 0;
        // Start looking at each element
        for (int j = 0; j < size - i - 1; j++) {
            // Compare the adjacent elements
            if (array[j] > array[j + 1]) {
                // Swap them
                swap(&array[j], &array[j + 1]);
                // Set the flag to true so we'll loop again after this iteration
                swapped = 1;
            }
        }
        // If no two elements were swapped by inner loop, the array is sorted
        if (!swapped) {
            break;
        }
    }
}

// Function to generate an array of random integers
int* generateRandomArray(int size) {
    int* array = (int*) malloc(size * sizeof(int));
    for (int i = 0; i < size; i++) {
        array[i] = rand() % 10000; // Random numbers between 0 and 9999
    }
    return array;
}

int main() {
    srand(time(NULL)); // Seed for random number generation
    int size = 1000;
    int* array = generateRandomArray(size);
    bubbleSort(array, size);
    free(array);
    return 0;
}