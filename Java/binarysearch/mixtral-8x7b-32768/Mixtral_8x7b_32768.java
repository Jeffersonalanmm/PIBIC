import java.util.Arrays;
import java.util.Random;

public class Mixtral_8x7b_32768 { // Adicionada a declaração da classe

    public static int binarySearch(int[] arr, int target) { // Renomeado o metodo para binarySearch para melhor padronização.
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

        Arrays.sort(arr);

        int target = rand.nextInt(10000);

        int result = binarySearch(arr, target); // Chamada para o método binarySearch
    }
}