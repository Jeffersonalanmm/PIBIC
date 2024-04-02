public class theAlgorithms {

    public static void sort(int[] arr) {
        int n = arr.length;

        // Construindo um heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }

        // Extração dos elementos um por um do heap
        for (int i = n - 1; i >= 0; i--) {
            // Move a raiz atual para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o siftDown no heap reduzido
            siftDown(arr, 0, i);
        }
    }

    private static void siftDown(int arr[], int k, int n) {
        int largest = k;
        int l = 2 * k + 1;
        int r = 2 * k + 2;

        // Se o filho da esquerda é maior que a raiz
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Se o filho da direita é maior que o maior até agora
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Se o maior não é a raiz
        if (largest != k) {
            int swap = arr[k];
            arr[k] = arr[largest];
            arr[largest] = swap;

            // Recursivamente constrói o heap afetado
            siftDown(arr, largest, n);
        }
    }

    public static void main(String[] args) {
        // Criando um array para teste
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Chamando o método de ordenação
        sort(arr);

        // Imprimindo o array após a ordenação
        System.out.println("Array após ordenação:");
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
