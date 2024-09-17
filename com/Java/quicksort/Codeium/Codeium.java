public class Codeium {

    /**
     * Sorts an array of integers using the Quicksort algorithm.
     *
     * @param arr the array to be sorted
     */
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Recursive Quicksort function.
     *
     * @param arr   the array to be sorted
     * @param low   the starting index of the subarray
     * @param high  the ending index of the subarray
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot element.
     *
     * @param arr   the array to be partitioned
     * @param low   the starting index of the subarray
     * @param high  the ending index of the subarray
     * @return the index of the pivot element
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param arr the array
     * @param i   the index of the first element
     * @param j   the index of the second element
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[1000];
        
        // Generate 1000 random values
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(1000); // Random value between 0 and 999
        }

        // Sort the array
        sort(array);
    }
}