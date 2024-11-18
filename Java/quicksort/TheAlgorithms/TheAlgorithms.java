import java.util.Random;

public class TheAlgorithms {

    /**
     * This method implements the Generic Quick Sort
     *
     * @param array The array to be sorted. Sorts the array in increasing order
     */
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * The sorting process
     *
     * @param left The first index of an array
     * @param right The last index of an array
     * @param array The array to be sorted
     */
    private <T extends Comparable<T>> void doSort(T[] array, final int left, final int right) {
        if (left < right) {
            final int pivot = randomPartition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    /**
     * Randomize the array to avoid the basically ordered sequences
     *
     * @param array The array to be sorted
     * @param left The first index of an array
     * @param right The last index of an array
     * @return the partition index of the array
     */
    private <T extends Comparable<T>> int randomPartition(T[] array, final int left, final int right) {
        final int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    /**
     * This method finds the partition index for an array
     *
     * @param array The array to be sorted
     * @param left The first index of an array
     * @param right The last index of an array
     * @return the partition index of the array
     */
    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        final int mid = (left + right) >>> 1;
        final T pivot = array[mid];

        while (left <= right) {
            while (less(array[left], pivot)) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    /**
     * Swap two elements in an array
     *
     * @param array The array where the elements will be swapped
     * @param i The index of the first element
     * @param j The index of the second element
     */
    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Compare two elements
     *
     * @param v The first element
     * @param w The second element
     * @return true if v is less than w
     */
    private <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Random random = new Random();
        TheAlgorithms sorter = new TheAlgorithms();
        
        // Create an array of 1000 random values
        Integer[] array = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(1000); // Random value between 0 and 999
        }

        // Sort the array
        sorter.sort(array);
    }
}
