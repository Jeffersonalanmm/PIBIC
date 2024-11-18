#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void beadSort(int *a, int n) {
    int i, j, max, sum;
    unsigned char *beads;

    // Find the maximum element
    max = a[0];
    for (i = 1; i < n; i++) {
        if (a[i] > max) {
            max = a[i];
        }
    }

    // Allocate memory for beads
    beads = (unsigned char *)calloc(1, max * n);
    
    // Mark the beads
    for (i = 0; i < n; i++) {
        for (j = 0; j < a[i]; j++) {
            beads[j * n + i] = 1;
        }
    }

    // Count the beads
    for (j = 0; j < max; j++) {
        for (sum = i = 0; i < n; i++) {
            sum += beads[j * n + i];
            beads[j * n + i] = 0;
        }
        for (i = n - sum; i < n; i++) {
            beads[j * n + i] = 1;
        }
    }

    // Put the sorted values back into array
    for (i = 0; i < n; i++) {
        for (j = 0; j < max && beads[j * n + i]; j++);
        a[i] = j;
    }

    // Free the allocated memory
    free(beads);
}

int main() {
    int n = 1000;
    int arr[n];

    // Initialize the array with values from 1000 to 1
    for (int i = 0; i < n; i++) {
        arr[i] = n - i;
    }

    // Sort the array using bead sort
    beadSort(arr, n);

    // Return 0 to indicate successful execution
    return 0;
}