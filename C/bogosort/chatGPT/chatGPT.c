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
    while (!is_sorted(array, size)) {
        shuffle(array, size);
    }
}

int main() {
    int array[ARRAY_SIZE];
    
    // Initialize the array with 1000 values in reverse order
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = ARRAY_SIZE - i;
    }
    
    srand(time(NULL));
    
    // Sort the array using Bogosort
    bogosort(array, ARRAY_SIZE);
    
    return 0;
}
