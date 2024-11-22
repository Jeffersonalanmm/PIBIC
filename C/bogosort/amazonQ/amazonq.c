#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

// Function to check if an array is sorted
bool is_sorted(int arr[], int size) {
    for (int i = 1; i < size; i++) {
        if (arr[i - 1] > arr[i]) {
            return false;
        }
    }
    return true;
}

// Function to shuffle an array
void shuffle(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        int random_index = rand() % size;
        int temp = arr[i];
        arr[i] = arr[random_index];
        arr[random_index] = temp;
    }
}

// Bogosort implementation
void bogosort(int arr[], int size) {
    while (!is_sorted(arr, size)) {
        shuffle(arr, size);
    }
}

int main() {
    const int SIZE = 1000;
    int arr[SIZE];

    // Initialize random number generator
    srand((unsigned)time(NULL));

    // Fill array with random values
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 10000; // Random values between 0 and 9999
    }

    // Sort the array using bogosort
    bogosort(arr, SIZE);

    return 0;
}
