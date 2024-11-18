import java.util.Arrays;
import java.util.Random;

public class Gemini {

    public static void bogoSort(int[] arr) {
        Random rand = new Random();
        while (!isSorted(arr)) {
            shuffle(arr, rand);
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] arr, Random rand) {
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }

        bogoSort(arr);
        // You might want to print the sorted array for verification
        // System.out.println(Arrays.toString(arr));
    }
}