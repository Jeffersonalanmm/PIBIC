import java.util.Arrays;

public class Rosetta {

    public static int binarySearch(int[] nums, int check) {
        int hi = nums.length - 1;
        int lo = 0;
        while (hi >= lo) {
            int guess = (lo + hi) >>> 1;  // from OpenJDK
            if (nums[guess] > check) {
                hi = guess - 1;
            } else if (nums[guess] < check) {
                lo = guess + 1;
            } else {
                return guess;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] haystack = new int[1000];
        
        // Preencher o array com valores aleatórios entre 100 e 1000
        for (int i = 0; i < haystack.length; i++) {
            haystack[i] = (int) (Math.random() * 901) + 100; // Valores aleatórios entre 100 e 1000
        }
        
        // Ordenar o array para que a busca binária funcione corretamente
        Arrays.sort(haystack);
        
        // Exemplo de valor a ser procurado (gerado aleatoriamente ou definido)
        int needle = (int) (Math.random() * 901) + 100; // Valor aleatório entre 100 e 1000
        
        // Realizar a busca binária
        binarySearch(haystack, needle);
    }
}
