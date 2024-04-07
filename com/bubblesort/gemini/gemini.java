package com.bubblesort.gemini;

public class gemini {
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;
    
        // Loop through the array n-1 times
        for (int i = 0; i < n - 1; i++) {
          swapped = false;
    
          // Compare adjacent elements and swap if they are in the wrong order
          for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
              swap(arr, j, j + 1);
              swapped = true;
            }
          }
    
          // If we haven't made any swaps in this iteration, the array is already sorted
          if (!swapped) {
            break;
          }
        }
      }
    
      // Helper method to swap two elements in the array
      private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    
      public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
    
        System.out.println("Sorted array:");
        for (int num : arr) {
          System.out.print(num + " ");
        }
      }
}
