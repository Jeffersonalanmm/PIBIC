import java.util.Random;

public class Llama_3_3_70b_versatile {

    /**
     * Checks if the array is sorted.
     *
     * @param array the array to check
     * @return true if the array is sorted, false otherwise
     */
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Shuffles the array.
     *
     * @param array the array to shuffle
     */
    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Sorts the array using Bogo sort.
     *
     * @param array the array to sort
     */
    public static void bogoSort(int[] array) {
        long iterations = 0;
        while (!isSorted(array)) {
            shuffle(array);
            iterations++;
        }
        System.out.println("Sorted array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\nNumber of iterations: " + iterations);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Gerar 10 valores aleatórios entre 0 e 10.000
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000);  // valores aleatórios entre 0 e 9999
        }

        // Chamar o algoritmo bogoSort para ordenar o array
        bogoSort(array);
    }
}