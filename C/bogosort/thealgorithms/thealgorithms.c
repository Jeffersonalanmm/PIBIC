#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

bool check_sorted(int *a, int n)
{
    while (--n >= 1)
    {
        if (a[n] < a[n - 1])
            return false;
    }
    return true;
}

void shuffle(int *a, int n)
{
    int i, t, r;
    for (i = 0; i < n; i++)
    {
        t = a[i];
        r = rand() % n;
        a[i] = a[r];
        a[r] = t;
    }
}

void sort(int *a, int n)
{
    while (!check_sorted(a, n)) shuffle(a, n);
}

int main()
{
    int n = 1000;
    int numbers[n];
    srand(time(NULL));  // Seed para geração de números aleatórios

    for (int i = 0; i < n; i++)
    {
        numbers[i] = rand() % 10000;  // Gera valores aleatórios entre 0 e 9999
    }

    sort(numbers, n);

    return 0;
}