#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to swap two elements
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to perform Bead Sort
void bead_sort(int arr[], int n) {
    // Create a copy of the array to store the beads
    int beads[n];

    // Initialize the beads array with zeros
    for (int i = 0; i < n; i++) {
        beads[i] = 0;
    }

    // Drop the beads
    for (int i = 0; i < n; i++) {
        beads[arr[i]]++;
    }

    // Collect the beads
    int index = 0;
    for (int i = 0; i < n; i++) {
        while (beads[i] > 0) {
            arr[index] = i;
            index++;
            beads[i]--;
        }
    }
}

int main() {
    // Set the seed for random number generation
    srand(time(NULL));

    // Define the size of the array
    int n = 1000;

    // Create an array of random integers
    int arr[n];
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }

    // Perform Bead Sort
    bead_sort(arr, n);

    return 0;
}