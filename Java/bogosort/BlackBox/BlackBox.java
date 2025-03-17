import java.util.Random;

public class BlackBox {

    // Method to check if the array is sorted
    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Method to shuffle the array
    private static void shuffle(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // Swap array[i] with the element at random index
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Bogosort implementation
    public static void bogosort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    // Main method to test the Bogosort algorithm
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();

        // Fill the array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Random integers from 0 to 9999
        }

        // Sort the array using Bogosort
        bogosort(array);
    }
}