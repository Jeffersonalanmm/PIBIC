#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int size, int target) {
    int left = 0;
    int right = size - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if target is present at mid
        if (arr[mid] == target) {
            return mid; // Target found
        }

        // If target is greater, ignore left half
        if (arr[mid] < target) {
            left = mid + 1;
        } 
        // If target is smaller, ignore right half
        else {
            right = mid - 1;
        }
    }

    return -1; // Target not found
}

int main() {
    // Initialize an array with 1000 sorted values
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = i; // Fill the array with values from 0 to 999
    }

    int target = 500; // Example target to search for
    int result = binarySearch(arr, 1000, target);

    // Result can be used here, e.g., check if found
    // Uncomment below line if you want to see the result
    // printf("Element found at index: %d\n", result);

    return 0;
}