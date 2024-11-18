#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    int *leftArr = (int *)malloc(n1 * sizeof(int));
    int *rightArr = (int *)malloc(n2 * sizeof(int));
    
    if (leftArr == NULL || rightArr == NULL) {
        return;
    }
    
    for (int i = 0; i < n1; i++)
        leftArr[i] = arr[left + i];
    for (int j = 0; j < n2; j++)
        rightArr[j] = arr[mid + 1 + j];
    
    int i = 0, j = 0, k = left;
    
    while (i < n1 && j < n2) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k++] = leftArr[i++];
        } else {
            arr[k++] = rightArr[j++];
        }
    }
    
    while (i < n1) {
        arr[k++] = leftArr[i++];
    }
    
    while (j < n2) {
        arr[k++] = rightArr[j++];
    }
    
    free(leftArr);
    free(rightArr);
}

void mergeSort(int arr[], int left, int right) {
    if (left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

int isSorted(int arr[], int size) {
    for (int i = 1; i < size; i++) {
        if (arr[i] < arr[i-1]) {
            return 0;
        }
    }
    return 1;
}

int main() {
    const int SIZE = 1000;
    int *arr = (int *)malloc(SIZE * sizeof(int));
    
    if (arr == NULL) {
        return 1;
    }
    
    // Initialize random seed
    srand(time(NULL));
    
    // Generate 1000 random values between 0 and 9999
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 10000;
    }
    
    // Sort the array
    mergeSort(arr, 0, SIZE - 1);
    
    // Verify if array is sorted
    if (isSorted(arr, SIZE)) {
        printf("Array sorted successfully\n");
    } else {
        printf("Sorting failed\n");
    }
    
    free(arr);
    return 0;
}
