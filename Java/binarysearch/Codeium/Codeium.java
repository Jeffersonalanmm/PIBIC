public class Codeium {

    /**
     * Searches for the specified element in the sorted array.
     *
     * @param arr   the sorted array to search in
     * @param target the element to search for
     * @return the index of the element if found, -1 otherwise
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at the mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // if we reach here, then element was not present
        return -1;
    }

    public static void main(String[] args) {
        // Create an array of 1000 random values
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

        // Sort the array
        java.util.Arrays.sort(arr);

        // Search for a random element
        int target = arr[(int) (Math.random() * 1000)];
        int result = binarySearch(arr, target);
    }
}