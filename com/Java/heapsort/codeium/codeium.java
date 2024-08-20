package codeium;
import java.util.Arrays;
import java.util.Random;

public class codeium {

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
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

        heapSort(array);
    }
}