#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void beadSort(int* arr, int n) {
    // Find the maximum value in the array
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Create a "beads" array
    int** beads = (int**)malloc((max + 1) * sizeof(int*));
    for (int i = 0; i <= max; i++) {
        beads[i] = (int*)calloc(n, sizeof(int));
    }

    // Place beads in the beads array
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < arr[i]; j++) {
            beads[j][i] = 1; // Place a bead
        }
    }

    // Sort the beads
    for (int i = max; i >= 0; i--) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (beads[i][j] == 1) {
                count++;
            }
        }
        for (int j = 0; j < count; j++) {
            arr[n - 1 - j] = i; // Set sorted values back to the array
        }
    }

    // Free the allocated memory
    for (int i = 0; i <= max; i++) {
        free(beads[i]);
    }
    free(beads);
}

int main() {
    int n = 1000;
    int* arr = (int*)malloc(n * sizeof(int));

    // Seed the random number generator
    srand(time(NULL));

    // Generate random values between 0 and 100
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 101; // Random values from 0 to 100
    }

    // Sort the array using bead sort
    beadSort(arr, n);

    // Free the allocated memory
    free(arr);
    
    return 0;
}