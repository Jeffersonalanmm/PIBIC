import java.util.Random;

public class AmazonQ {
    private static final Random random = new Random();

    private static void bogoSort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] arr) {
        // Fisher-Yates shuffle algorithm
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        
        // Generate 10 random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000); // Random numbers between 0 and 9999
        }

        // Sort the array using BogoSort
        bogoSort(arr);
    }
}
