#include <stdlib.h>
#include <time.h>

void sift_down(int *array, int size, int index) {
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    int largest = index;

    if (left < size && array[left] > array[largest])
        largest = left;

    if (right < size && array[right] > array[largest])
        largest = right;

    if (largest != index) {
        int temp = array[index];
        array[index] = array[largest];
        array[largest] = temp;
        sift_down(array, size, largest);
    }
}

void heap_sort(int *array, int size) {
    // Build the heap
    for (int i = size / 2 - 1; i >= 0; --i)
        sift_down(array, size, i);

    // Extract elements one by one
    for (int i = size - 1; i >= 0; --i) {
        int temp = array[0];
        array[0] = array[i];
        array[i] = temp;
        sift_down(array, i, 0);
    }
}

int main() {
    srand(time(NULL));
    int size = 1000;
    int *array = (int *)malloc(size * sizeof(int));

    for (int i = 0; i < size; ++i)
        array[i] = rand() % 10000 + 1;

    heap_sort(array, size);

    free(array);
    return 0;
}