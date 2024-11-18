import java.util.Arrays;
import java.util.Random;

public class Gemini {

    public static void beadSort(int[] array) {
        int maxVal = Arrays.stream(array).max().getAsInt();

        // Create a 2D array to represent the beads
        int[][] beads = new int[array.length][maxVal];

        // Fill the beads array based on the input values
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                beads[i][j] = 1;
            }
        }

        // Simulate the bead dropping process, column by column
        for (int j = maxVal - 1; j >= 0; j--) {
            for (int i = 0; i < array.length - 1; i++) {
                if (beads[i][j] == 1 && beads[i + 1][j] == 0) {
                    beads[i][j] = 0;
                    beads[i + 1][j] = 1;
                }
            }
        }

        // Extract the sorted values from the beads array
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < maxVal; j++) {
                if (beads[i][j] == 1) {
                    count++;
                }
            }
            array[i] = count;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        beadSort(array);

        // You can now use the sorted array for further processing
    }
}