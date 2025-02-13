#include <stdlib.h>
#include <time.h>

int is_sorted(int *arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}

void shuffle(int *arr, int n) {
    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

void bogo_sort(int *arr, int n) {
    srand(time(NULL));
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
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