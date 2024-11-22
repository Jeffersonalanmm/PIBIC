#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Structure to represent a bead
typedef struct {
    int value;
    int count;
} Bead;

// Function to create a new bead
Bead* create_bead(int value) {
    Bead* bead = (Bead*) malloc(sizeof(Bead));
    bead->value = value;
    bead->count = 1;
    return bead;
}

// Function to merge two beads
Bead* merge_beads(Bead* bead1, Bead* bead2) {
    if (bead1->value == bead2->value) {
        bead1->count += bead2->count;
        free(bead2);
        return bead1;
    } else if (bead1->value < bead2->value) {
        return bead1;
    } else {
        return bead2;
    }
}

// Function to perform bead sort
void bead_sort(int* arr, int n) {
    Bead** beads = (Bead**) malloc(n * sizeof(Bead*));
    for (int i = 0; i < n; i++) {
        beads[i] = create_bead(arr[i]);
    }

    for (int i = 1; i < n; i++) {
        Bead* current = beads[i];
        int j = i - 1;
        while (j >= 0 && beads[j]->value > current->value) {
            beads[j + 1] = beads[j];
            j--;
        }
        beads[j + 1] = current;
    }

    // Merge beads with the same value
    for (int i = 1; i < n; i++) {
        beads[i] = merge_beads(beads[i - 1], beads[i]);
    }

    // Copy sorted values back to the original array
    for (int i = 0; i < n; i++) {
        arr[i] = beads[i]->value;
    }

    // Free memory
    for (int i = 0; i < n; i++) {
        free(beads[i]);
    }
    free(beads);
}

int main() {
    srand(time(NULL));
    int n = 1000;
    int* arr = (int*) malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        arr[i] = rand() % 1000;
    }

    bead_sort(arr, n);

    // No print statements, just return
    return 0;
}