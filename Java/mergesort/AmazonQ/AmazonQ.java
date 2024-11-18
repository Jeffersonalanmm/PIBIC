public class AmazonQ {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSortHelper(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Avoid potential overflow
            
            // Sort the left half
            mergeSortHelper(arr, left, mid, temp);
            
            // Sort the right half
            mergeSortHelper(arr, mid + 1, right, temp);
            
            // Merge the sorted halves
            merge(arr, left, mid, right, temp);
        }
    }

        // Copy both parts into the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;     // Pointer for the left side
        int j = mid + 1;  // Pointer for the right side
        int k = left;     // Pointer for the merged array

        // Merge the two parts into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left side
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }

        // Note: We don't need to copy remaining elements from the right side
        // because they are already in their correct positions
    }

    // Utility method to print an array

    // Main method for testing
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(arr);
        
    }
}
