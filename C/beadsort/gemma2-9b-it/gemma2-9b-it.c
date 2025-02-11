#include <stdio.h>
#include <stdlib.h>

#define MAX_VALUE 10000

void bead_sort(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    int *beads = (int *)malloc((max + 1) * sizeof(int));
    for (int i = 0; i <= max; i++) {
        beads[i] = 0;
    }

    for (int i = 0; i < n; i++) {
        beads[arr[i]]++;
    }

    int index = 0;
    for (int i = 0; i <= max; i++) {
        for (int j = 0; j < beads[i]; j++) {
            arr[index++] = i;
        }
    }

    free(beads);
}

int main() {
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % MAX_VALUE;
    }

    bead_sort(arr, 1000);

    return 0;
}