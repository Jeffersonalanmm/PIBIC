#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void bead_sort(int *arr, int n) {
    int max = arr[0];
    // Find the maximum element
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Create a grid to represent the beads
    unsigned char *beads = calloc(n * max, sizeof(unsigned char));

    // Initialize the beads grid
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < arr[i]; j++) {
            beads[i * max + j] = 1;
        }
    }

    // Sort beads
    for (int j = 0; j < max; j++) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += beads[i * max + j];
            beads[i * max + j] = 0;
        }
        for (int i = n - sum; i < n; i++) {
            beads[i * max + j] = 1;
        }
    }

    // Update the input array with sorted values
    for (int i = 0; i < n; i++) {
        int j;
        for (j = 0; j < max && beads[i * max + j]; j++);
        arr[i] = j;
    }

    free(beads);
}

int main() {
    int n = 1000;
    int arr[1000];
    
    // Initialize array with example values (here using random values for simplicity)
    srand(0);  // Seed for reproducibility
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }

    bead_sort(arr, n);

    // Array is now sorted
    return 0;
}
