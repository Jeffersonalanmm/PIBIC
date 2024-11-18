#include <stdio.h>

void max_heapify(int *a, int i, int n);
void heapsort(int *a, int n);
void build_maxheap(int *a, int n);

void max_heapify(int *a, int i, int n)
{
    int j, temp;
    temp = a[i];
    j = 2 * i;
    while (j <= n)
    {
        if (j < n && a[j + 1] > a[j])
            j = j + 1;
        if (temp > a[j])
        {
            break;
        }
        else if (temp <= a[j])
        {
            a[j / 2] = a[j];
            j = 2 * j;
        }
    }
    a[j / 2] = temp;
    return;
}

void heapsort(int *a, int n)
{
    int i, temp;
    for (i = n; i >= 2; i--)
    {
        temp = a[i];
        a[i] = a[1];
        a[1] = temp;
        max_heapify(a, 1, i - 1);
    }
}

void build_maxheap(int *a, int n)
{
    int i;
    for (i = n / 2; i >= 1; i--)
    {
        max_heapify(a, i, n);
    }
}

int main()
{
    int n = 1000, i;
    int a[1001]; // Ajuste para tamanho 1001 para indexação de 1 a 1000

    srand(time(NULL)); // Inicializa a semente aleatória

    // Preenche o array com 1000 números aleatórios entre -1000 e 1000
    for (i = 1; i <= n; i++)
    {
        a[i] = rand() % 2001 - 1000; // Valores entre -1000 e 1000
    }

    build_maxheap(a, n);
    heapsort(a, n);

    return 0;
}