#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ARRAY_SIZE 1000

// Function to check if an array is sorted
int is_sorted(int *array, int size) {
    for (int i = 0; i < size - 1; i++) {
        if (array[i] > array[i + 1]) {
            return 0;
        }
    }
    return 1;
}

// Function to shuffle the array randomly
void shuffle(int *array, int size) {
    for (int i = 0; i < size; i++) {
        int j = rand() % size;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

// Bogosort algorithm
void bogosort(int *array, int size) {
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
    bogosort(arr, SIZE);

    return 0;
}
