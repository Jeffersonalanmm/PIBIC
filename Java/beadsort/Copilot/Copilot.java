import java.util.Arrays;
import java.util.Random;

public class Copilot {

    public static void beadSort(int[] array) {
        int max = Arrays.stream(array).max().orElse(0);
        int len = array.length;
        int[][] beads = new int[len][max];

        // Initialize the beads
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < array[i]; j++) {
                beads[i][j] = 1;
            }
        }

        for (int j = 0; j < max; j++) {
            // Count beads at each level
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += beads[i][j];
                beads[i][j] = 0;
            }

            // Drop beads
            for (int i = len - sum; i < len; i++) {
                beads[i][j] = 1;
            }
        }

        // Write sorted values back to array
        for (int i = 0; i < len; i++) {
            int j;
            for (j = 0; j < max && beads[i][j] == 1; j++);
            array[i] = j;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        beadSort(array);

        // Optionally, print the sorted array to verify
        // System.out.println(Arrays.toString(array));
    }
}