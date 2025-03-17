import java.util.Random;
public class Llama_3_3_70b_versatile {

    /**
     * Searches for the target element in the given sorted array.
     * 
     * @param array  the sorted array to search in
     * @param target the element to search for
     * @return the index of the target element if found, -1 otherwise
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is at the mid index
            if (array[mid] == target) {
                return mid;
            }

            // If the target is less than the mid element, search in the left half
            if (array[mid] > target) {
                right = mid - 1;
            }

            // If the target is greater than the mid element, search in the right half
            else {
                left = mid + 1;
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000); // Random values between 0 and 9999
        }

        Arrays.sort(array);
        int target = array[rand.nextInt(array.length)]; // Pick a random target from the array

        int result = binarySearch(array, target);
    }
}