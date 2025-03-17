import java.util.Random;
public class Llama_3_2_90b_vision_preview {

    /**
     * Sorts an array using the heapsort algorithm.
     *
     * @param array the array to be sorted
     */
    public static void sort(int[] array) {
        buildHeap(array);
        for (int end = array.length - 1; end > 0; end--) {
            swap(array, 0, end);
            heapify(array, 0, end);
        }
    }

    /**
     * Builds a max heap from the given array.
     *
     * @param array the array to build the heap from
     */
    private static void buildHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }
    }

    /**
     * Heapifies the given array starting from the specified index.
     *
     * @param array the array to heapify
     * @param index the index to start heapifying from
     * @param end the end index of the heap
     */
    private static void heapify(int[] array, int index, int end) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < end && array[left] > array[largest]) {
            largest = left;
        }

        if (right < end && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(array, index, largest);
            heapify(array, largest, end);
        }
    }

    /**
     * Swaps two elements in the given array.
     *
     * @param array the array to swap elements in
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Tamanho do vetor
        int size = 1000;

        // Inicializando o vetor com 1000 números aleatórios entre 1 e 1000
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000) + 1; // Gera números entre 1 e 1000
        }

        sort(array); // Ordena o array
    }

    /**
     * Prints the given array.
     *
     * @param array the array to print
     */
    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}