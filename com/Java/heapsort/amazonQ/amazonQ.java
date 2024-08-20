package amazonQ;
import java.util.Arrays;
import java.util.Random;

public class amazonQ {

  public static void sort(int[] array) {

    int n = array.length;

    // Build max heap
    for(int i = n/2 - 1; i >= 0; i--) {
      heapify(array, n, i);
    }

    // Heap sort
    for(int i=n-1; i>=0; i--) {
      int temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      heapify(array, i, 0);
    }
  }

  public static void heapify(int[] arr, int n, int i) {
    int largest = i; 
    int l = 2*i + 1; 
    int r = 2*i + 2; 

    if (l < n && arr[l] > arr[largest])
      largest = l;

    if (r < n && arr[r] > arr[largest])
      largest = r;

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

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

        // Chamando o método de ordenação
        sort(array);
    }
}
