public class ChatGPT {

    // Binary search method
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid potential overflow

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is smaller, ignore the right half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If target is larger, ignore the left half
            else {
                left = mid + 1;
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        // Create and fill the array with values
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i; // Array will contain values from 0 to 999
        }

        // Test the binarySearch with a target value
        int target = 500; // Example target value
        int result = binarySearch(arr, target);

        // Optionally, output result if needed, but it's removed based on request
        // If found, result will be the index; if not, it will be -1
    }
}
