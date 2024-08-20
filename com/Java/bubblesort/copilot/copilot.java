package com.bubblesort.copilot;

import java.util.Random;

public class copilot {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe copilot
        copilot c = new copilot();

        // Criando um array com 1000 valores
        int[] array = new int[10000];

        // Preenchendo o array com valores aleatórios entre 1 e 100
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1; // Gera um número aleatório entre 1 e 100
        }

        // Chamando o método de ordenação
        c.bubbleSort(array);
    }
}