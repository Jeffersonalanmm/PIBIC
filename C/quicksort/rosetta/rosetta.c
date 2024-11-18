#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void quicksort(int *A, int len);

int main(void) {
    int n = 1000;  // Array size set to 1000
    int *a = (int *)malloc(n * sizeof(int));  // Dynamically allocated array

    // Seed the random number generator
    srand(time(NULL));

    // Generate 1000 random values between 0 and 999
    for (int i = 0; i < n; i++) {
        a[i] = rand() % 1000;
    }

    // Perform quicksort on the array
    quicksort(a, n);

    // Free the dynamically allocated memory
    free(a);

    return 0;
}

void quicksort(int *A, int len) {
    if (len < 2) return;

    int pivot = A[len / 2];

    int i, j;
    for (i = 0, j = len - 1; ; i++, j--) {
        while (A[i] < pivot) i++;
        while (A[j] > pivot) j--;

        if (i >= j) break;

        int temp = A[i];
        A[i]     = A[j];
        A[j]     = temp;
    }

    quicksort(A, i);
    quicksort(A + i, len - i);
}
