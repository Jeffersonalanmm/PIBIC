#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int binarySearch(int arr[], int n, int target) {
    int left = 0;
    int right = n - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1; // not found
}

int main() {
    int n = 1000;
    int arr[n];
    srand(time(NULL));

    // Generate a sorted array of 1000 random values
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }

    // Sort the array
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }

    int target = arr[n/2]; // search for a value in the middle of the array

    binarySearch(arr, n, target);

    return 0;
}