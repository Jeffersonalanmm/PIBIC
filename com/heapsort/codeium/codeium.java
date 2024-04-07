package com.heapsort.codeium;
import java.util.Arrays;

public class codeium {

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Extract elements from heap one by one
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    /*public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }*/
}