#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to swap two elements
void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to check if an array is sorted
int is_sorted(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}

// Function to shuffle an array
void shuffle(int arr[], int n) {
    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        swap(&arr[i], &arr[j]);
    }
}

// Bogo Sort function
void bogo_sort(int arr[], int n) {
    //srand(time(NULL)); lembrar q fiz isso
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
    }
}

// Function to print an array
//void print_array(int arr[], int n) {
//    for (int i = 0; i < n; i++) {
//        printf("%d ", arr[i]);
//    }
//    printf("\n");
//}

int main()
{
    int n = 1000;
    int numbers[n];
    srand(time(NULL));  // Seed para geração de números aleatórios

    for (int i = 0; i < n; i++)
    {
        numbers[i] = (rand() % 10000) + 1;  // Gera valores aleatórios entre 0 e 9999
    }

    bogo_sort(numbers, n);

    return 0;
}