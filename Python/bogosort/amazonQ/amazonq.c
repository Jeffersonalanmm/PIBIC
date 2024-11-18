#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(int arr[], int n) {
    if (n < 2) return;  // Early return for empty or single-element arrays
    
    bool swapped;
    int newn;  // To optimize by tracking last swap position
    
    do {
        swapped = false;
        newn = 0;
        
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                swap(&arr[i - 1], &arr[i]);
                swapped = true;
                newn = i;
            }
        }
        // Update n to optimize next pass
        n = newn;
        
    } while (swapped);
}

int main() {
    const int SIZE = 1000;
    int *arr = malloc(SIZE * sizeof(int));
    
    // Initialize random seed
    srand(time(NULL));
    
    // Generate 1000 random numbers
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 10000;  // Random numbers between 0 and 9999
    }
    
    // Sort the array
    bubbleSort(arr, SIZE);
    
    // Free allocated memory
    free(arr);
    
    return 0;
}
