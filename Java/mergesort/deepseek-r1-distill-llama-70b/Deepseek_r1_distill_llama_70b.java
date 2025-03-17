import java.util.Random;
public class Deepseek_r1_distill_llama_70b {

    /**
     * Sorts an array using the MergeSort algorithm.
     * @param array the array to be sorted
     * @return a new sorted array
     */
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;
        int[] left = new int[midpoint];
        int[] right = new int[array.length - midpoint];

        System.arraycopy(array, 0, left, 0, midpoint);
        System.arraycopy(array, midpoint, right, 0, array.length - midpoint);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    /**
     * Merges two sorted arrays into one sorted array.
     * @param left the first sorted array
     * @param right the second sorted array
     * @return a new sorted array containing all elements from both input arrays
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Tamanho do vetor
        int size = 1000;

        // Inicializando o vetor com 1000 números aleatórios entre 1 e 1000
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000) + 1; // Gera números entre 1 e 1000
        }

        // Realizando a ordenação com MergeSort
        int[] sortedArray = mergeSort(array);
    }
}