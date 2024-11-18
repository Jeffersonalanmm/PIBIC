import java.util.Arrays;
import java.util.Random;

public class AmazonQ {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Use this instead of (left + right) / 2 to avoid integer overflow
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Element not found
    }

    // Recursive implementation of binary search
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        }

        return binarySearchRecursive(arr, target, left, mid - 1);
    }

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random random = new Random();

        // Generate 1000 random numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000); // Random numbers between 0 and 9999
        }

        // Binary search requires a sorted array
        Arrays.sort(numbers);

        // Example search - searching for a random value from the array
        int randomIndex = random.nextInt(numbers.length);
        int targetValue = numbers[randomIndex];

        // Using iterative binary search
        int resultIterative = binarySearch(numbers, targetValue);

        // Using recursive binary search
        int resultRecursive = binarySearchRecursive(numbers, targetValue, 0, numbers.length - 1);
    }
}
