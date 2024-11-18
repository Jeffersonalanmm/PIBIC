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
    int array[1000];

    // Populate the array with random values
    for (int i = 0; i < 1000; i++) {
        array[i] = rand() % 1000;
    }

    bogo_sort(array, 1000);

    // (You might want to print the sorted array here for verification)

    return 0;
}