#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bogoSort(int arr[], int n) {
    srand(time(NULL));
    while (1) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        if (i == n - 1) {
            break;
        }
        for (int i = 0; i < n; i++) {
            int j = rand() % n;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}

int main() {
    int arr[10];
    for (int i = 0; i <= 10; i++) {
        arr[i] = rand() % 1000;
    }

    bogoSort(arr, 10);

    return 0;
}