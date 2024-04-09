package com.bubblesort.gemini;

import java.util.Random;

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
    // Criando um array com 1000 valores
    int[] array = new int[1000];

    // Preenchendo o array com valores aleatórios entre 1 e 100
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(100) + 1; // Gera um número aleatório entre 1 e 100
    }

    // Chamando o método de ordenação
    sort(array);
  }
}
