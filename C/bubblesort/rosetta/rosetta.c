#include <stdio.h>

void bubble_sort (int *a, int n) {
    int i, t, j = n, s = 1;
    while (s) {
        s = 0;
        for (i = 1; i < j; i++) {
            if (a[i] < a[i - 1]) {
                t = a[i];
                a[i] = a[i - 1];
                a[i - 1] = t;
                s = 1;
            }
        }
        j--;
    }
}

int main() {
    int n = 1000;
    int a[n];
    srand(time(NULL));

    for (int i = 0; i < n; i++) {
        a[i] = rand() % 10000;  // Gera valores aleatórios entre 0 e 9999
    }

    bubble_sort(a, n);

    return 0;
}