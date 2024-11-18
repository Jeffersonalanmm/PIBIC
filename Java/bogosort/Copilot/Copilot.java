import java.util.Arrays;
import java.util.Random;

public class Copilot {

    public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();

        // Generate 1000 random values
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // Sort the array using BogoSort
        bogoSort(array);

        // Print the sorted array
        System.out.println(Arrays.toString(array));
    }

    public static void bogoSort(int[] array) {
        Random random = new Random();
        while (!isSorted(array)) {
            for (int i = 0; i < array.length; i++) {
                int randomIndex = random.nextInt(array.length);
                int temp = array[i];
                array[i] = array[randomIndex];
                array[randomIndex] = temp;
            }
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}