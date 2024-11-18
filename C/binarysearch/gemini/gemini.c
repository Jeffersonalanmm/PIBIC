#include <stdio.h>

int binarySearch(int arr[], int low, int high, int key) {
    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == key)
            return mid;

        if (arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }

    return -1; // Key not found
}

int main() {
    int arr[1000];

    // Populate the array with values (you can replace this with your desired input)
    for (int i = 0; i < 1000; i++) {
        arr[i] = i; // Example: array with values from 0 to 999
    }

    int key = 500; // Element to be searched
    int n = sizeof(arr) / sizeof(arr[0]);
    int result = binarySearch(arr, 0, n - 1, key);

    return 0;
}