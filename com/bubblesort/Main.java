package com.bubblesort;

import java.util.Arrays;

import com.bubblesort.theAlgorithms.theAlgorithms;

public class Main {
    public static void main (String args[]){

        int[] array = {12, 11, 13, 5, 6, 7};
        theAlgorithms theAlgorithms = new theAlgorithms();
        theAlgorithms.sort(array);
        System.out.println("Array ordenado por The Algorithms:");
        System.out.println(Arrays.toString(array));
    }
}
