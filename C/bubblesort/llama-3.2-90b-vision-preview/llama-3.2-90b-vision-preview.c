#include <stdio.h>
#include <stdlib.h>

/**
 * Swaps two elements in an array.
 *
 * @param arr The array containing the elements to swap.
 * @param i The index of the first element to swap.
 * @param j The index of the second element to swap.
 */
void swap(int* arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

/**
 * Performs the bubble sort algorithm on an array.
 *
 * @param arr The array to sort.
 * @param n The number of elements in the array.
 */
void bubble_sort(int* arr, int n) {
    for (int i = n - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
            }
        }
    }
}

/**
 * Prints an array to the console.
 *
 * @param arr The array to print.
 * @param n The number of elements in the array.
 *
 * @note This function is commented out by default to meet the request.
 * To print the array, uncomment this function and the corresponding calls.
 */
void print_array(int* arr, int n) {
    // for (int i = 0; i < n; i++) {
    //     printf("%d ", arr[i]);
    // }
    // printf("\n");
}

int main() {
    int n = 1000; // Number of elements in the array
    int* arr = (int*)malloc(n * sizeof(int)); // Allocate memory for the array

    // Initialize the array with random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }

    // Sort the array using bubble sort
    bubble_sort(arr, n);

    // Print the sorted array
    // print_array(arr, n);

    free(arr); // Deallocate memory

    return 0;
}