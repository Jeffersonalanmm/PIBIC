#include <stdlib.h>
#include <time.h>
#include <stdio.h>

void merge(int *array, int *left, int *right, int n1, int n2) {
    int i = 0, j = 0, k = 0;
    while (i < n1 && j < n2) {
        if (left[i] <= right[j]) {
            array[k++] = left[i++];
        } else {
            array[k++] = right[j++];
        }
    }
    while (i < n1) {
        array[k++] = left[i++];
    }
    while (j < n2) {
        array[k++] = right[j++];
    }
}

void merge_sort(int *array, int size) {
    if (size <= 1) return;
    int mid = size / 2;
    int *left = array;
    int *right = array + mid;
    int n1 = mid, n2 = size - mid;
    merge_sort(left, n1);
    merge_sort(right, n2);
    merge(array, left, right, n1, n2);
}

int main() {
    srand(time(NULL));
    int array[1000];
    for (int i = 0; i < 1000; i++) {
        array[i] = rand() % 1001;
    }
    merge_sort(array, 1000);
    return 0;
}