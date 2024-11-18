#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void quicksort(int *array, int low, int high) {
    if (low < high) {
        int pivot = partition(array, low, high);
        quicksort(array, low, pivot - 1);
        quicksort(array, pivot + 1, high);
    }
}

int partition(int *array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (array[j] < pivot) {
            i++;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return i + 1;
}

int main() {
    int array[1000];
    srand(time(NULL));
    for (int i = 0; i < 1000; i++) {
        array[i] = rand() % 10000;
    }

    quicksort(array, 0, 999);

    return 0;
}