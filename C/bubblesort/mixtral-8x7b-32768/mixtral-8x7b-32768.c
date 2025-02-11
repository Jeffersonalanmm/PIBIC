#include <stdio.h>

void bubbleSort(int arr[], int n) {
  for(int i = 0; i < n-1; i++) {
    for(int j = 0; j < n-i-1; j++) {
      if(arr[j] > arr[j+1]) {
        // Swap arr[j] and arr[j+1]
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
      }
    }
  }
}

int main() {
  int arr[1000];

  // Initialize the array with random values
  for(int i = 0; i < 1000; i++) {
    arr[i] = rand() % 1000;
  }

  // Call the bubbleSort function
  bubbleSort(arr, 1000);

  return 0;
}