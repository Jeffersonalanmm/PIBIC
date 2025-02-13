#include <stdlib.h>
#include <time.h>

int is_sorted(int *arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return 0;
        }
    }
    return 1;
}

void shuffle(int *arr, int n) {
    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

void bogo_sort(int *arr, int n) {
    while (!is_sorted(arr, n)) {
        shuffle(arr, n);
    }
}

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