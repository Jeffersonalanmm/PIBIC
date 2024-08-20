package com.bubblesort.theAlgorithms;

import java.util.Random;

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
    public static void main(String[] args) {
        theAlgorithms c = new theAlgorithms();

        // Criando um array com 1000 valores
        int[] array = new int[10000];

        // Preenchendo o array com valores aleatórios entre 1 e 100
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1; // Gera um número aleatório entre 1 e 100
        }

        // Chamando o método de ordenação
        c.sort(array);
    }    
}
