#include <stdio.h>
#include <stdlib.h>

// Function to merge two sorted subarrays
void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Create temporary arrays
    int left_arr[n1], right_arr[n2];

    // Copy data to temporary arrays
    for (int i = 0; i < n1; i++) {
        left_arr[i] = arr[left + i];
    }
    for (int j = 0; j < n2; j++) {
        right_arr[j] = arr[mid + 1 + j];
    }

    // Merge the temporary arrays
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (left_arr[i] <= right_arr[j]) {
            arr[k] = left_arr[i];
            i++;
        } else {
            arr[k] = right_arr[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements of left_arr[], if any
    while (i < n1) {
        arr[k] = left_arr[i];
        i++;
        k++;
    }

    // Copy remaining elements of right_arr[], if any
    while (j < n2) {
        arr[k] = right_arr[j];
        j++;
        k++;
    }
}

// Function to perform merge sort
void merge_sort(int arr[], int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;

        // Recursively sort the left and right subarrays
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        // Merge the sorted subarrays
        merge(arr, left, mid, right);
    }
}

// Function to generate a random array of size 'n'
void generate_random_array(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }
}

int main() {
    int n = 1000;
    int arr[n];

    // Generate a random array of size 'n'
    srand(123); // For reproducibility
    generate_random_array(arr, n);

    // Perform merge sort
    merge_sort(arr, 0, n - 1);

    return 0;
}