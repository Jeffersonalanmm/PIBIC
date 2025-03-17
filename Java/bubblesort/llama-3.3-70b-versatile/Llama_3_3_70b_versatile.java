import java.util.Random;
public class Llama_3_3_70b_versatile {

    /**
     * Sorts an array of integers using the bubble sort algorithm.
     *
     * @param array the array to be sorted
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Prints an array of integers.
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