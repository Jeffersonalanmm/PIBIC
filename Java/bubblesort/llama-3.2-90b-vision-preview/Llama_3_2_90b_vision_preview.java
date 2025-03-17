import java.util.Random;
public class Llama_3_2_90b_vision_preview {

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param array the array to be sorted
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Create a flag that will allow the function to terminate early if there's nothing left to sort
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap them if they are in the wrong order
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Prints the elements of an array.
     *
     * @param array the array to be printed
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
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
}