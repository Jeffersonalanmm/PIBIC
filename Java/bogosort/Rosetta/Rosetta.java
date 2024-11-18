public class Rosetta
{
    public static void main(String[] args)
    {
        // Gerando um array de 1000 valores aleatórios
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);  // Números aleatórios entre 0 e 999
        }

        Rosetta now = new Rosetta();

        // Ordenando o array (sem prints)
        now.bogo(arr);
    }

    void bogo(int[] arr)
    {
        // Manter o controle do número de embaralhamentos
        int shuffle = 1;
        for (; !isSorted(arr); shuffle++)
            shuffle(arr);
    }

    void shuffle(int[] arr)
    {
        // Algoritmo de embaralhamento Fisher-Yates
        int i = arr.length - 1;
        while (i > 0)
            swap(arr, i--, (int) (Math.random() * i));
    }

    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean isSorted(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }
}
