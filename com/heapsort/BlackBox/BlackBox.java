package com.heapsort.BlackBox;
public class BlackBox {
    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than root
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        // Criando um array para teste
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Obtendo o tamanho do array
        int n = arr.length;

        // Chamando o método heapify
        BlackBox.heapify(arr, n, 0);

        // Imprimindo o array após a chamada ao método heapify
        System.out.println("Array após heapify:");
        printArray(arr);
    }

    // Método auxiliar para imprimir o array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    
}