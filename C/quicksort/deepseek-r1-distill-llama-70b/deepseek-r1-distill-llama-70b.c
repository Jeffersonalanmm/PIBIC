#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function prototypes
void quick_sort(int* array, int low, int high);
int partition(int* array, int low, int high);
void swap(int* a, int* b);

int main() {
    const int size = 1000;
    int* array = (int*)malloc(size * sizeof(int));
    
    // Read 1000 integers from input
    for (int i = 0; i < size; ++i) {
        scanf("%d", &array[i]);
    }
    
    // Sort the array using Quick Sort
    quick_sort(array, 0, size - 1);
    
    // Don't forget to free the allocated memory
    free(array);
    
    return 0;
}

void quick_sort(int* array, int low, int high) {
    if (low < high) {
        int pivot_index = partition(array, low, high);
        quick_sort(array, low, pivot_index - 1);
        quick_sort(array, pivot_index + 1, high);
    }
}

int partition(int* array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
    
    for (int j = low; j < high; ++j) {
        if (array[j] <= pivot) {
            ++i;
            swap(&array[i], &array[j]);
        }
    }
    swap(&array[i + 1], &array[high]);
    return i + 1;
}

void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}