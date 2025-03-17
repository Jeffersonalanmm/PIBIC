import java.util.Random;
public class Gemma2_9b_it {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid to avoid potential overflow

            if (array[mid] == target) {
                return mid; // Target found at index mid
            } else if (array[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Target not found in the array
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];

        // Preenchendo o array com valores aleatórios e ordenando
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(10000); // Números entre 0 e 9999
        }
        Arrays.sort(array);

        // Buscando o elemento com Binary Search
        int result = Gemma2_9b_it.binarySearch(array, target);

    }
}