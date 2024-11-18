import java.util.Random;

public class Codeium {

    /**
     * Bead sort algorithm implementation.
     *
     * @param arr array to be sorted
     */
    public static void beadSort(int[] arr) {
        int max = findMax(arr);
        int[] beads = new int[max + 1];

        // Initialize beads
        for (int i = 0; i < arr.length; i++) {
            beads[arr[i]]++;
        }

        // Count beads
        int[] sorted = new int[arr.length];
        int index = 0;
        for (int i = 0; i < beads.length; i++) {
            while (beads[i]-- > 0) {
                sorted[index++] = i;
            }
        }

        // Copy sorted array back to original array
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }

    /**
     * Find the maximum value in the array.
     *
     * @param arr array to find maximum value in
     * @return maximum value
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
        // Generate 1000 random values
        Random random = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }

        // Sort array using bead sort
        beadSort(arr);
    }
}