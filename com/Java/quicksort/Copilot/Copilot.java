public class Copilot {

    // Main function to call quicksort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Helper function to perform quicksort
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Function to partition the array and return the pivot index
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Function to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[1000];
        
        // Generate 1000 random values
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(1000); // Random value between 0 and 999
        }

        // Sort the array
        quickSort(array);
    }
}