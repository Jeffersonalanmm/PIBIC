import java.util.Arrays;

public class BlackBox {

    // Binary search method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To prevent overflow

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid; // Target found
            }
            // If target is greater, ignore the left half
            else if (array[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        // Create an array of 1000 sorted integers
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i; // Fill the array with values 0 to 999
        }

        // Example target to search for
        int target = 500; // You can change this value to test different targets
        int result = binarySearch(array, target);

        // If needed, you can check the result
        // System.out.println("Element found at index: " + result);
    }
}