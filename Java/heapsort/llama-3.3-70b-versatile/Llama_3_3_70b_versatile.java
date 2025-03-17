import java.util.Random;
public class Llama_3_3_70b_versatile {

    /**
     * Sorts an array using the Heapsort algorithm.
     *
     * @param array the array to be sorted
     */
    public static void heapsort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
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
     * Heapifies the given array, starting from the given index.
     *
     * @param array the array to heapify
     * @param index the index to start heapifying from
     * @param size  the size of the heap
     */
    private static void heapify(int[] array, int index, int size) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && array[left] > array[largest]) {
            largest = left;
        }

        if (right < size && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(array, index, largest);
            heapify(array, largest, size);
        }
    }

    /**
     * Swaps two elements in the given array.
     *
     * @param array the array to swap elements in
     * @param i     the index of the first element
     * @param j     the index of the second element
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

        heapsort(array); // Ordena o array
    }

    /**
     * Prints the given array.
     *
     * @param array the array to print
     */
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}