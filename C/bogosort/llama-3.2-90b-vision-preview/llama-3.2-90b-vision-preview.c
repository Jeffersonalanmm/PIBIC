#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to check if an array is sorted
int is_sorted(int* arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}

// Function to shuffle an array
void shuffle(int* arr, int n) {
    for (int i = 0; i < n; i++) {
        int j = rand() % n;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Bogo Sort function
void bogo_sort(int* arr, int n) {
    srand(time(NULL)); // Seed the random number generator
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
    }
}

// Function to print an array (commented out)
// void print_array(int* arr, int n) {
//     for (int i = 0; i < n; i++) {
//         printf("%d ", arr[i]);
//     }
//     printf("\n");
// }

int main() {
    int n = 1000;
    int* arr = (int*)malloc(n * sizeof(int));

    // Initialize the array with values from 1 to n
    for (int i = 0; i < n; i++) {
        arr[i] = i + 1;
    }

    // Shuffle the array to create an unsorted input
    shuffle(arr, n);

    // Sort the array using Bogo Sort
    bogo_sort(arr, n);

    // Free the allocated memory
    free(arr);

    return 0;
}