#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void bogo_sort(int arr[], int n) {
    int is_sorted = 0;
    while (!is_sorted) {
        is_sorted = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                is_sorted = 0;
            }
        }
    }
}

int main()
{
    int n = 10;
    int numbers[n];

    for (int i = 0; i < n; i++)
    {
        numbers[i] = (rand() % 10000) + 1;  // Gera valores aleatórios entre 0 e 9999
    }

    bogo_sort(numbers, n);

    return 0;
}