#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int size, int target) {
    int left = 0;
    int right = size - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if target is present at mid
        if (arr[mid] == target) {
            return mid;
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

    // Target is not present in array
    return -1;
}

int main() {
    int arr[1000];
    int size = sizeof(arr) / sizeof(arr[0]);

    // Initialize array with values 0 to 999
    for (int i = 0; i < size; i++) {
        arr[i] = i;
    }

    int target = 500; // Example target value to search for
    int result = binarySearch(arr, size, target);

    return 0;
}