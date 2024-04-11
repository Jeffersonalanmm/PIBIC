package com.bubblesort.amazonQ;

import java.util.Random;

public class amazonQ {

  public static void bubbleSort(int[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j+1]) {
          int temp = array[j];
          array[j] = array[j+1]; 
          array[j+1] = temp;
        }
      }
    }

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