#include <stdio.h>

int binarySearch(int arr[], int left, int right, int target) {
    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if the target is present at mid
        if (arr[mid] == target) {
            return mid;
        }

        // If target is greater, ignore the left half
        if (arr[mid] < target) {
            left = mid + 1;
        }
        // If target is smaller, ignore the right half
        else {
            right = mid - 1;
        }
    }
    // Target is not present in the array
    return -1;
}

int main() {
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = i * 2;  // Filling array with sorted values: 0, 2, 4, ..., 1998
    }

    int target = 998;  // Example target value to search

    int result = binarySearch(arr, 0, 999, target);

    // result will hold the index if found, or -1 if not found
    if (result != -1) {
        // Target found at index `result`
    } else {
        // Target not found
    }

    return 0;
}
