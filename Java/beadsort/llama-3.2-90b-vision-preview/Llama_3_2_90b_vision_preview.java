import java.util.Random;
public class Llama_3_2_90b_vision_preview {

    /**
     * Sorts an array of integers using the Beadsort algorithm.
     *
     * @param arr the array to be sorted
     * @return the sorted array
     */
    public static int[] sort(int[] arr) {
        int max = findMax(arr);
        int[] beads = new int[max + 1];

        // Create a "grid" to simulate the beads falling
        for (int i = 0; i < arr.length; i++) {
            beads[arr[i]]++;
        }

        // "Drop" the beads and count the number of beads in each column
        int[] sorted = new int[arr.length];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (beads[i] > 0) {
                sorted[index++] = i;
                beads[i]--;
            }
        }

        return sorted;
    }

    /**
     * Finds the maximum value in an array.
     *
     * @param arr the array to search
     * @return the maximum value
     */
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
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
        int[] sortedArray = Llama_3_2_90b_vision_preview.sort(array);
    }
}