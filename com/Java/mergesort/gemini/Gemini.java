import java.util.Arrays;

public class Gemini {

    public static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n <= 1) {
            return; // Base case: array of size 1 or less is already sorted
        }

        // Divide the array into two halves
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        int leftSize = left.length;
        int rightSize = right.length;

        // Merge the two sorted arrays into the original array
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements from the left array
        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        // Copy any remaining elements from the right array
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int size = 1000;
        int[] arr = new int[size];

        // Generate 1000 random values
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000); // Random values between 0 and 9999
        }

        mergeSort(arr);

        // No print statements as requested
    }
}