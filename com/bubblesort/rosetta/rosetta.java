package com.bubblesort.rosetta;

import java.util.Random;

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

    public static void main(String[] args) {
        // Criando um array com 1000 valores
        int[] array = new int[10000];

        // Preenchendo o array com valores aleatórios entre 1 e 100
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1; // Gera um número aleatório entre 1 e 100
        }

        // Chamando o método de ordenação
        bubbleSort(array);
    }
}