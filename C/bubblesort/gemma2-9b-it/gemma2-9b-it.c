#include <stdio.h>
#include <stdlib.h>

void bubbleSort(int arr[], int n) {
    int i, j;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int arr[1000];
    
    // Initialize array with random values (you can modify this)
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 1000; 
    }

    bubbleSort(arr, 1000);

    return 0;
}