#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void shuffle(int *array, int n) {
    for (int i = 0; i < n; i++) {
        int j = rand() % n;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

int is_sorted(int *array, int n) {
    for (int i = 1; i < n; i++) {
        if (array[i - 1] > array[i]) {
            return 0;
        }
    }
    return 1;
}

void bogo_sort(int *array, int n) {
    srand(time(NULL));
    while (!is_sorted(array, n)) {
        shuffle(array, n);
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