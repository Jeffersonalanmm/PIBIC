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
    while (!is_sorted(array, size)) {
        shuffle(array, size);
    }
}

int main() {
    int size = 1000;
    int array[size];

    // Initialize the array with 1000 values
    for (int i = 0; i < size; i++) {
        array[i] = rand() % 1000; // Random values between 0 and 999
    }

    // Seed the random number generator
    srand(time(NULL));

    // Sort the array using Bogo Sort
    bogo_sort(array, size);

    return 0;
}