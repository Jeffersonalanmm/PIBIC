public class QuickSort {

    // Function to partition the array on the basis of pivot
    private static int partition(int[] array, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = array[high];

        // Pointer for the greater element
        int i = (low - 1);

        // Traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                // If element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // Swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Return the position from where partition is done
        return (i + 1);
    }

    // Function to perform quicksort
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Utility function to print the array
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Driver program to test the algorithm
    public static void main(String[] args) {
        int[] array = { 10, 7, 8, 9, 1, 5 };
        int n = array.length;

        System.out.println("Unsorted Array:");
        printArray(array);

        quickSort(array, 0, n - 1);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}
