#include <stdio.h>
#include <stdlib.h>

#define MAX_VALUE 1000
#define ARRAY_SIZE 1000

void bead_sort(int arr[], int n) {
    int max_value = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] > max_value) {
            max_value = arr[i];
        }
    }

    int matrix[max_value][n];
    for (int i = 0; i < max_value; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = 0;
        }
    }

    // Populate the matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < arr[i]; j++) {
            matrix[j][i] = 1;
        }
    }

    // Simulate the beads falling
    for (int i = max_value - 1; i >= 0; i--) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 1) {
                int k = i;
                while (k < max_value - 1 && matrix[k + 1][j] == 0) {
                    matrix[k][j] = 0;
                    matrix[k + 1][j] = 1;
                    k++;
                }
            }
        }
    }

    // Extract the sorted values
    for (int i = 0; i < n; i++) {
        int count = 0;
        for (int j = 0; j < max_value; j++) {
            if (matrix[j][i] == 1) {
                count++;
            }
        }
        arr[i] = count;
    }
}

int main() {
    int arr[ARRAY_SIZE];

    // Generate random input values
    for (int i = 0; i < ARRAY_SIZE; i++) {
        arr[i] = rand() % MAX_VALUE;
    }

    bead_sort(arr, ARRAY_SIZE);

    // You can uncomment the following to print the sorted array:
    // for (int i = 0; i < ARRAY_SIZE; i++) {
    //     printf("%d ", arr[i]);
    // }
    // printf("\n");

    return 0;
}