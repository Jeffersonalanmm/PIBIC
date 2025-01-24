#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to check if an array is sorted
int is_sorted(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}

// Function to shuffle an array
void shuffle(int arr[], int n) {
    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// Function to implement Bogo Sort
void bogo_sort(int arr[], int n) {
    srand(time(NULL)); // Seed for random number generation
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
    }
}

// Function to print an array (commented out as per request)
// void print_array(int arr[], int n) {
//     for (int i = 0; i < n; i++) {
//         printf("%d ", arr[i]);
//     }
//     printf("\n");
// }

int main() {
    int n = 1000;
    int* arr = (int*) malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000; // Initialize with random values
    }
    bogo_sort(arr, n);
    free(arr);
    return 0;
}