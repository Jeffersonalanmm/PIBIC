package beadsort.ChatGPT;
import java.util.Arrays;

public class ChatGPT {

    public static void beadSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0); // Find the maximum value in the array

        // Create the "bead" array, representing the beads in columns
        int[][] beads = new int[array.length][max];

        // Place beads in the beads array based on the values in the original array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                beads[i][j] = 1;
            }
        }

        // Perform the "gravity" step to simulate the beads falling down
        for (int col = 0; col < max; col++) {
            int fallCount = 0;
            for (int row = 0; row < array.length; row++) {
                if (beads[row][col] == 1) {
                    fallCount++;
                }
            }
            // Reassign the fall count to the original array
            array[col] = fallCount;
        }
    }

    public static void main(String[] args) {
        // Create an array with 1000 random values
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000); // Generate random values between 0 and 999
        }

        // Call beadSort to sort the array
        beadSort(array);
    }
}
