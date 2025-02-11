#include <stdlib.h>

void bead_sort(int *arr, int len) {
    int max = arr[0];
    for (int i = 1; i < len; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    int *beads = (int*)calloc(max + 1, sizeof(int));
    for (int i = 0; i < len; i++) {
        beads[arr[i]]++;
    }

    int index = 0;
    for (int i = 0; i < max + 1; i++) {
        while (beads[i] > 0) {
            arr[index++] = i;
            beads[i]--;
        }
    }

    free(beads);
}

int main() {
    int arr[1000];
    for (int i = 0; i < 1000; i++) {
        arr[i] = rand() % 1000;
    }

    bead_sort(arr, 1000);

    return 0;
}