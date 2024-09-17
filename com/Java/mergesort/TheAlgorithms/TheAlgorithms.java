package com.Java.mergesort;
import java.util.NoSuchElementException;
import static com.Java.mergesort.SortUtils.less;


/**
 * Generic merge sort algorithm.
 *
 * @see SortAlgorithm
 */
class TheAlgorithms implements SortAlgorithm {

    private Comparable[] aux;

    /**
     * Generic merge sort algorithm implements.
     *
     * @param unsorted the array which should be sorted.
     * @param <T> Comparable class.
     * @return sorted array.
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        aux = new Comparable[unsorted.length];
        doSort(unsorted, 0, unsorted.length - 1);
        return unsorted;
    }

    /**
     * @param arr the array to be sorted.
     * @param left the first index of the array.
     * @param right the last index of the array.
     */
    private <T extends Comparable<T>> void doSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            doSort(arr, left, mid);
            doSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two parts of an array.
     *
     * @param arr the array to be merged.
     * @param left the first index of the array.
     * @param mid the middle index of the array.
     * @param right the last index of the array merges two parts of an array in
     * increasing order.
     */
    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        System.arraycopy(arr, left, aux, left, right + 1 - left);

        for (int k = left; k <= right; k++) {
            if (j > right) {
                arr[k] = (T) aux[i++];
            } else if (i > mid) {
                arr[k] = (T) aux[j++];
            } else if (less(aux[j], aux[i])) {
                arr[k] = (T) aux[j++];
            } else {
                arr[k] = (T) aux[i++];
            }
        }
    }
    public static void main(String[] args) {
        // Create an instance of TheAlgorithms
        TheAlgorithms algorithm = new TheAlgorithms();

        // Generate 1000 random values
        Random rand = new Random();
        int size = 1000;
        Integer[] array = new Integer[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000); // Random values between 0 and 9999
        }

        // Sort the array using merge sort
        algorithm.sort(array);

        // No print statements as requested
    }
}