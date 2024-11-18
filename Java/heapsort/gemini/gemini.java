package gemini;

import java.util.Random;

public class gemini {

  public static void sort(int[] arr) {
    int n = arr.length;

    // Build a max heap from the input array
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    // One by one extract an element from heap
    for (int i = n - 1; i > 0; i--) {
      // Move current root to end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // call max heapify on the reduced heap
      heapify(arr, i, 0);
    }
  }

  static void heapify(int arr[], int n, int i) {
    int largest = i; // initialize largest as root
    int left = 2 * i + 1; // left = 2*i + 1
    int right = 2 * i + 2; // right = 2*i + 2

    // If left child is larger than root
    if (left < n && arr[left] > arr[largest])
      largest = left;

    // If right child is larger than largest so far
    if (right < n && arr[right] > arr[largest])
      largest = right;

    // If largest is not root
    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      // Recursively heapify the affected sub-tree
      heapify(arr, n, largest);
    }
  }

      public static void main(String[] args) {
        // Criando um array com 1000 valores
        int[] array = new int[1000];

        // Preenchendo o array com valores aleatórios entre 1 e 100
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1; // Gera um número aleatório entre 1 e 100
        }
        
        gemini.sort(array);
    }

}
  