#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

// Function to check if the array is sorted
bool is_sorted(int *array, int size) {
    for (int i = 0; i < size - 1; i++) {
        if (array[i] > array[i + 1]) {
            return false;
        }
    }
    return true;
}

// Function to shuffle the array
void shuffle(int *array, int size) {
    for (int i = 0; i < size; i++) {
        int random_index = rand() % size;
        int temp = array[i];
        array[i] = array[random_index];
        array[random_index] = temp;
    }
}

// Bogo Sort algorithm
void bogo_sort(int *array, int size) {
    srand(time(NULL));
    while (!is_sorted(array, size)) {
        shuffle(array, size);
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
    bogo_sort(arr, SIZE);

    return 0;
}