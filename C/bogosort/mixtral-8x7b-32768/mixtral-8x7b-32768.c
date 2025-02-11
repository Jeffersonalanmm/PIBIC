#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bogo_sort(int arr[], int n) {
    int is_sorted = 0;
    while (!is_sorted) {
        is_sorted = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                is_sorted = 0;
            }
        }
    }
}

int main() {
    int n = 1000;
    int *arr = malloc(n * sizeof(int));

    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % n;
    }

    bogo_sort(arr, n);

    free(arr);
    return 0;
}