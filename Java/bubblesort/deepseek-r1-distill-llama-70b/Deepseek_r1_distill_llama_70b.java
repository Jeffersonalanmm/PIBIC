import java.util.Random;
public class Deepseek_r1_distill_llama_70b {

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     * This implementation includes an optimization to stop early if the array becomes sorted.
     *
     * @param array The array to be sorted.
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return; // Already sorted
        }

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            // The last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break; // Array is sorted
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Gerar 10 valores aleatórios entre 0 e 10.000
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000);  // valores aleatórios entre 0 e 9999
        }

        // Chamar o algoritmo bubbleSort para ordenar o array
        bubbleSort(array);
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
}