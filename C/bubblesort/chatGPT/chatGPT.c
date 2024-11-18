#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bubbleSort(int arr[], int n) {
    int i, j;
    int swapped;
    for (i = 0; i < n - 1; i++) {
        swapped = 0;
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = 1;
            }
        }
        // If no elements were swapped, the array is already sorted
        if (swapped == 0) break;
    }
}

int main() {
    int n = 1000;
    int arr[n];

    // Initialize random seed
    srand(time(0));

    // Fill array with random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000;  // Random values between 0 and 9999
    }

    // Sort the array
    bubbleSort(arr, n);

    return 0;
}
