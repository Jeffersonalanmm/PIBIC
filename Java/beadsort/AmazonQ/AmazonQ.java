import java.util.Random;

public class AmazonQ {
    public static void beadSort(int[] arr) {
        if (arr.length == 0) return;

        // Find the maximum element
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a grid for beads
        boolean[][] grid = new boolean[arr.length][max];

        // Drop the beads
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                grid[i][j] = true;
            }
        }

        // Let beads fall to the bottom
        for (int j = 0; j < max; j++) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (grid[i][j]) {
                    count++;
                }
            }
            // Count beads in each column
            for (int i = arr.length - 1; i >= arr.length - count; i--) {
                grid[i][j] = true;
            }
            for (int i = arr.length - count - 1; i >= 0; i--) {
                grid[i][j] = false;
            }
        }

        // Put the sorted numbers back into array
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < max; j++) {
                if (grid[i][j]) {
                    count++;
                }
            }
            arr[i] = count;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random random = new Random();
        
        // Generate 1000 random numbers between 1 and 1000
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000) + 1;
        }

        // Sort the array using bead sort
        beadSort(numbers);
    }
}
