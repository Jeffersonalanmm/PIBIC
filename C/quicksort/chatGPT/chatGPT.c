#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void quicksort(int arr[], int low, int high) {
    if (low < high) {
        int pivot = partition(arr, low, high);
        quicksort(arr, low, pivot - 1);
        quicksort(arr, pivot + 1, high);
    }
}

int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
}

int main() {
    int n = 1000;
    int arr[n];
    srand(time(NULL));
    
    // Generate 1000 random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000;  // Random values from 0 to 9999
    }

    // Sort the array
    quicksort(arr, 0, n - 1);

    return 0;
}
