#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Function to perform Bead Sort
void beadSort(int arr[], int n) {
    // Create a grid to simulate the beads
    int* grid = (int*)calloc(n, sizeof(int));

    // Initialize the grid with zeros
    memset(grid, 0, n * sizeof(int));

    // Simulate the beads falling through the grid
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < arr[i]; j++) {
            grid[j]++;
        }
    }

    // Reconstruct the sorted array from the grid
    int k = 0;
    for (int i = 0; i < n; i++) {
        while (grid[i] > 0) {
            arr[k++] = i + 1;
            grid[i]--;
        }
    }

    // Free the grid memory
    free(grid);
}

// Function to print the array
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Main function
int main() {
    int n = 1000;
    int* arr = (int*)malloc(n * sizeof(int));

    // Initialize the array with random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 100 + 1;
    }

    // Perform Bead Sort
    beadSort(arr, n);

    // Print the sorted array
    // printArray(arr, n);

    // Free the array memory
    free(arr);

    return 0;
}