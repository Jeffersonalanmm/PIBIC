#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bubbleSort(int arr[], int n) {
    int i, j, temp;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int arr[1000];
    srand(time(NULL));

    // Populate the array with random values
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 1000;
    }

    bubbleSort(arr, 1000);

    // You can uncomment the following lines to print the sorted array
    // for (int i = 0; i < 1000; i++) {
    //     printf("%d ", arr[i]);
    // }

    return 0;
}