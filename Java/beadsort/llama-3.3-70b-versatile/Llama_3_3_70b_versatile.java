import java.util.Random;
public class Llama_3_3_70b_versatile {

    /**
     * Sorts an array of integers using the Beadsort algorithm.
     *
     * @param array the array to be sorted
     * @return the sorted array
     */
    public static int[] beadSort(int[] array) {
        // Find the maximum value in the array to determine the number of pegs
        int max = findMax(array);

        // Initialize the pegs as an array of zeros
        int[] pegs = new int[max + 1];

        // Drop the beads (i.e., increment the corresponding pegs)
        for (int bead : array) {
            pegs[bead]++;
        }

        // Collect the beads (i.e., construct the sorted array)
        int[] sortedArray = new int[array.length];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < pegs[i]; j++) {
                sortedArray[index++] = i;
            }
        }

        return sortedArray;
    }

    /**
     * Finds the maximum value in an array.
     *
     * @param array the array to search
     * @return the maximum value
     */
    private static int findMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];

        // Preenchendo o array com valores aleatórios
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Números entre 0 e 999
        }

        // Ordenando com BeadSort
        int[] sortedArray = Llama_3_3_70b_versatile.beadSort(array);
    }

    /**
     * Prints an array to the console.
     *
     * @param array the array to print
     */
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}