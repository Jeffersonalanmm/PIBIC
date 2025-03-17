import java.util.Random;

public class ChatGPT {
    
    // Method to check if the array is sorted
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to shuffle the array randomly
    public static void shuffle(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    // Bogosort algorithm
    public static void bogosort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    // Default main method to test Bogosort with 10 values
    public static void main(String[] args) {
        int size = 10;  // Size of the array
        int[] array = new int[size];
        
        // Fill the array with random values
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000);  // Random values between 0 and 999
        }

        // Apply Bogosort to the array
        bogosort(array);
    }
}
