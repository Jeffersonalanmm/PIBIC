#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high]; // Choosing the last element as pivot
    int i = (low - 1);     // Index of the smaller element

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quicksort(int arr[], int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);

        quicksort(arr, low, pi - 1);  // Recursively sort elements before partition
        quicksort(arr, pi + 1, high); // Recursively sort elements after partition
    }
}

int main() {
    int arr[1000];
    srand(time(NULL)); // Seed for random number generation

    // Generate 1000 random values
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 10000; // Random values between 0 and 9999
    }

    quicksort(arr, 0, 999); // Sort the array

    // Uncomment the following lines if you want to verify the sorting
    /*
    for (int i = 0; i < 1000; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    */

    return 0;
}