import java.util.Arrays;

class TheAlgorithms {

    /**
     * @param array is an array where the element should be found
     * @param key is an element which should be found
     * @param <T> is any comparable type
     * @return index of the element
     */
    public <T extends Comparable<T>> int find(T[] array, T key) {
        return search(array, key, 0, array.length - 1);
    }

    /**
     * This method implements the Generic Binary Search
     *
     * @param array The array to make the binary search
     * @param key The number you are looking for
     * @param left The lower bound
     * @param right The upper bound
     * @return the location of the key
     */
    private <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
        if (right < left) {
            return -1; // this means that the key not found
        }
        // find median
        int median = (left + right) >>> 1;
        int comp = key.compareTo(array[median]);

        if (comp == 0) {
            return median;
        } else if (comp < 0) {
            return search(array, key, left, median - 1);
        } else {
            return search(array, key, median + 1, right);
        }
    }

    public static void main(String[] args) {
        TheAlgorithms binarySearch = new TheAlgorithms();
        
        // Gerando 1000 valores aleatórios entre 100 e 1000
        Integer[] haystack = new Integer[1000];
        for (int i = 0; i < haystack.length; i++) {
            haystack[i] = (int) (Math.random() * 901) + 100; // Valores aleatórios entre 100 e 1000
        }
        
        // Ordenando o array para que a busca binária funcione corretamente
        Arrays.sort(haystack);
        
        // Exemplo de valor a ser procurado (gerado aleatoriamente ou definido)
        int needle = (int) (Math.random() * 901) + 100; // Valor aleatório entre 100 e 1000
        
        // Realizando a busca binária
        binarySearch.find(haystack, needle);
    }
}
