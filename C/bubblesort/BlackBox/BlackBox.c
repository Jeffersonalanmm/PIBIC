#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bubbleSort(int arr[], int n) {
    int i, j, temp;
    int swapped;

    for (i = 0; i < n - 1; i++) {
        swapped = 0; // Flag to check if any swapping occurred
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = 1; // Set the flag to true
            }
        }
        // If no two elements were swapped by inner loop, then break
        if (swapped == 0) {
            break;
        }
    }
}

int main() {
    int n = 1000;
    int arr[1000];

    // Seed the random number generator
    srand(time(NULL));

    // Fill the array with random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000; // Random values between 0 and 9999
    }

    // Sort the array using Bubble Sort
    bubbleSort(arr, n);

    // The array is now sorted, and you can use it as needed

    return 0;
}