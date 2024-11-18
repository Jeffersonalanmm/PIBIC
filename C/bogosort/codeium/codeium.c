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

// Bogo sort function
void bogo_sort(int* arr, int n) {
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
    }
}

int main() {
    srand(time(NULL)); // Seed for random number generation
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 1000; // Initialize array with random values
    }
    bogo_sort(arr, 1000);
    return 0;
}