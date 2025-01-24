#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to perform binary search
int binary_search(int arr[], int target, int low, int high) {
    if (high >= low) {
        int mid = low + (high - low) / 2;

        // Check if target is present at mid
        if (arr[mid] == target)
            return mid;

        // If target is greater, ignore left half
        if (arr[mid] < target)
            return binary_search(arr, target, mid + 1, high);

        // If target is smaller, ignore right half
        return binary_search(arr, target, low, mid - 1);
    }

    // If we reach here, then the target is not present in array
    return -1;
}

int main() {
    // Initialize random number generator
    srand(time(NULL));

    // Create an array of 1000 sorted integers
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = i;
    }

    // Choose a random target value from the array
    int target = arr[rand() % 1000];

    // Perform binary search
    int result = binary_search(arr, target, 0, 999);

    //printf("Result: %d\n", result);
    return 0;
}