#include <stdio.h>

int max (int *a, int n, int i, int j, int k) {
    int m = i;
    if (j < n && a[j] > a[m]) {
        m = j;
    }
    if (k < n && a[k] > a[m]) {
        m = k;
    }
    return m;
}

void downheap (int *a, int n, int i) {
    while (1) {
        int j = max(a, n, i, 2 * i + 1, 2 * i + 2);
        if (j == i) {
            break;
        }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        i = j;
    }
}

void heapsort (int *a, int n) {
    int i;
    for (i = (n - 2) / 2; i >= 0; i--) {
        downheap(a, n, i);
    }
    for (i = 0; i < n; i++) {
        int t = a[n - i - 1];
        a[n - i - 1] = a[0];
        a[0] = t;
        downheap(a, n - i - 1, 0);
    }
}

int main() {
    int a[1000];
    srand(time(NULL)); // Inicializa a semente aleatória

    // Preenche o array com 1000 números aleatórios entre -1000 e 1000
    for (int i = 0; i < 1000; i++) {
        a[i] = rand() % 2001 - 1000; // Valores entre -1000 e 1000
    }

    // Ordena o array
    heapsort(a, 1000);

    return 0;
}