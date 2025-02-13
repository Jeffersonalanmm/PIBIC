#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to check if the array is sorted
int isSorted(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        if (arr[i] < arr[i - 1]) {
            return 0; // Not sorted
        }
    }
    return 1; // Sorted
}

// Function to shuffle the array
void shuffle(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        int j = rand() % n;
        // Swap arr[i] and arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Bogosort function
void bogosort(int arr[], int n) {
    srand(time(NULL));
    while (!isSorted(arr, n)) {
        shuffle(arr, n);
    }
}

int main() {
    const int SIZE = 10;
    int arr[SIZE];

    // Fill array with random values
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 1000; // Random values between 0 and 9999
    }

    // Sort the array using bogosort
    bogosort(arr, SIZE);

    return 0;
}