#include <stdio.h>
#include <stdlib.h>

/**
 * Binary search function.
 *
 * @param arr   The sorted array to search in.
 * @param target The value to search for.
 * @param low   The starting index of the search range.
 * @param high  The ending index of the search range.
 *
 * @return The index of the target value if found, -1 otherwise.
 */
int binary_search(int* arr, int target, int low, int high) {
    while (low <= high) {
        int mid = low + (high - low) / 2;

        // Check if target is present at the mid
        if (arr[mid] == target)
            return mid;

        // If target is greater, ignore left half
        if (arr[mid] < target)
            low = mid + 1;

        // If target is smaller, ignore right half
        else
            high = mid - 1;
    }

    // If we reach here, then element was not present
    return -1;
}

int main() {
    // Create a sorted array of 1000 values
    int* arr = (int*)malloc(1000 * sizeof(int));
    for (int i = 0; i < 1000; i++) {
        arr[i] = i;
    }

    // Search for a value in the array
    int target = 512;
    int result = binary_search(arr, target, 0, 999);

    // Check if the value was found
    if (result != -1) {
        // printf("Element found at index %d\n", result);
    } else {
        // printf("Element not found in array\n");
    }

    free(arr);
    return 0;
}