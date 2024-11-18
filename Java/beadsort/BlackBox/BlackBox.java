import java.util.Random;

public class BlackBox {

    public static void beadSort(int[] array) {
        // Find the maximum value to determine the size of the beads
        int max = findMax(array);
        // Create a 2D array (beads) to represent the beads
        int[][] beads = new int[array.length][max];

        // Place beads in the 2D array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                beads[i][j] = 1; // Place a bead
            }
        }

        // Drop the beads
        for (int j = 0; j < max; j++) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += beads[i][j]; // Sum the beads in each column
            }
            for (int i = 0; i < sum; i++) {
                beads[array.length - 1 - i][j] = 1; // Place beads in the last rows
            }
        }

        // Retrieve the sorted values
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < max; j++) {
                count += beads[i][j]; // Count the beads in each row
            }
            array[i] = count; // Set the sorted value
        }
    }

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
        Random random = new Random();
        int[] array = new int[1000];

        // Generate 1000 random values between 0 and 100
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101); // Random values from 0 to 100
        }

        // Sort the array using Bead Sort
        beadSort(array);

        // The array is now sorted; you can use it as needed.
        // For example, you could return it, process it, etc.
    }
}