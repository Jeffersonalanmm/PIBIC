#include <stdlib.h>
#include <time.h>

void beadsort(int *arr, int len) {
    int max = arr[0];
    
    // Find maximum element
    for (int i = 1; i < len; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    
    // Allocate memory for beads
    unsigned char *beads = (unsigned char *)calloc(max * len, sizeof(unsigned char));
    if (beads == NULL) return;  // Memory allocation check
    
    // Set beads for each number
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < arr[i]; j++) {
            beads[i * max + j] = 1;
        }
    }
    
    // Let beads fall
    for (int j = 0; j < max; j++) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += beads[i * max + j];
            beads[i * max + j] = 0;
        }
        
        // Count beads after falling
        for (int i = len - 1; i >= len - sum; i--) {
            beads[i * max + j] = 1;
        }
    }
    
    // Put sorted values back in array
    for (int i = 0; i < len; i++) {
        int count = 0;
        for (int j = 0; j < max; j++) {
            count += beads[i * max + j];
        }
        arr[i] = count;
    }
    
    free(beads);
}

int main() {
    const int SIZE = 1000;
    int arr[SIZE];
    
    // Initialize random seed
    srand((unsigned int)time(NULL));
    
    // Generate 1000 random numbers
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 1000;  // Random numbers between 0 and 999
    }
    
    // Sort the array
    beadsort(arr, SIZE);
    
    return 0;
}
