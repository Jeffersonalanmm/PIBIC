package com.bubblesort.rosetta;
public class rosetta{
    public static void bubbleSort(int[] comparable) { // public static <E extends Comparable<? super E>> void bubbleSort(E[] comparable)
        boolean changed = false;
        do {
            changed = false;
            for (int a = 0; a < comparable.length - 1; a++) {
                if (comparable[a] > comparable[a + 1]) { // (comparable[a].compareTo(comparable[a + 1]) > 0)
                    int tmp = comparable[a];                 //E tmp = comparable[a];
                    comparable[a] = comparable[a + 1];
                    comparable[a + 1] = tmp;
                    changed = true;
                }
            }
        } while (changed);
    }
}