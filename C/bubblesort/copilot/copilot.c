#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bubbleSort(int arr[], int n) {
    int i, j, temp;
    for (i = 0; i < n-1; i++) {
        for (j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int main() {
    int n = 1000;
    int arr[n];
    srand(time(0));

    // Generate 1000 random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 10000;
    }

    bubbleSort(arr, n);
    return 0;
}