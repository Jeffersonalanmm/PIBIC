import java.util.Random;

public class TheAlgorithms {

    private static final Random RANDOM = new Random();

    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1].compareTo(array[i]) < 0) { // Comparação direta usando compareTo
                return false;
            }
        }
        return true;
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T[] array) {
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + RANDOM.nextInt(length - i);
            swap(array, randomIndex, i);
        }
    }

    // Swap two elements in the array
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {
        while (!isSorted(array)) {
            nextPermutation(array);
        }
        return array;
    }

    public static void main(String[] args) {
        // Gerando 1000 valores aleatórios
        Integer[] integers = new Integer[1000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = RANDOM.nextInt(1000); // Números entre 0 e 999
        }

        TheAlgorithms bogoSort = new TheAlgorithms();

        // Ordenando o array (sem print)
        bogoSort.sort(integers);

        // O array já estará ordenado, mas sem saída de print
    }
}
