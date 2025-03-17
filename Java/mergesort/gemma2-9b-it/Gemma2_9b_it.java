import java.util.Random;
public class Gemma2_9b_it {

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // Base case: already sorted
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copy data to subarrays
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Recursively sort subarrays
        mergeSort(left);
        mergeSort(right);

        // Merge sorted subarrays
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements from left subarray
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements from right subarray
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Tamanho do vetor
        int size = 1000;

        // Inicializando o vetor com 1000 números aleatórios entre 1 e 1000
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000) + 1; // Gera números entre 1 e 1000
        }

        // Realizando a ordenação com MergeSort
        mergeSort(arr);

    }
}