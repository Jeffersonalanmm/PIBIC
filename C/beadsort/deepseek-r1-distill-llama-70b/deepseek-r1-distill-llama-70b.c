#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
//#include <stdbool.h> PLAUSIBLE, se colocar isso resolve
void beadSort(int arr[], int size) {
    int next[size];
    bool changed;
    do {
        changed = false;
        memcpy(next, arr, sizeof(int) * size);
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                next[i] = arr[i + 1];
                next[i + 1] = arr[i];
                changed = true;
            }
        }
        memcpy(arr, next, sizeof(int) * size);
    } while (changed);
}

int main() {
    srand(time(NULL));
    const int size = 1000;
    int arr[size];
    for (int i = 0; i < size; i++) {
        arr[i] = rand() % 1001; // Generate random values between 0 and 1000
    }
    beadSort(arr, size);
    return 0;
}