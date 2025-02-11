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
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
    }
}

int main(void) {
    srand(time(NULL));
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = 1;
    }
    bogo_sort(arr, 1000);
    return 0;
}