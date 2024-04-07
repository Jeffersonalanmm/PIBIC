package com.bubblesort.theAlgorithms;
public class theAlgorithms{
    public int[] sort(int[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    private static void swap(int[] array, int idx, int idy) {
        int swap = array[idx - 1];
        array[idx - 1] = array[idy - 1];
        array[idy - 1] = swap;
    }
}
