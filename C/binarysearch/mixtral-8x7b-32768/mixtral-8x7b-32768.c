#include <stdio.h>

int binary_search(int arr[], int size, int target) {
    int left = 0;
    int right = size - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1; // target not found
}

int main() {
    int arr[1000];

    // populate the array with 1000 random values
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 1000;
    }

    // sort the array
    for (int i = 0; i < 1000 - 1; i++) {
        for (int j = 0; j < 1000 - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    // search for a target value
    int target = 500;
    int result = binary_search(arr, 1000, target);

    if (result != -1) {
        printf("Target %d found at index %d\n", target, result);
    } else {
        printf("Target %d not found\n", target);
    }

    return 0;
}