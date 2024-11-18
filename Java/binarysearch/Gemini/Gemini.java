import java.util.Arrays;
import java.util.Random;

public class Gemini {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Create a sorted array of 1000 random integers
        int[] arr = new int[1000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        Arrays.sort(arr);

        // Target value to search for
        int target = random.nextInt(10000);

        // Perform binary search
        int index = binarySearch(arr, target);
    }
}