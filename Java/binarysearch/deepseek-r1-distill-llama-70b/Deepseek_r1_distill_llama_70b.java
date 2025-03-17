import java.util.Random;
//import java.util.Arrays; PLAUSIBLE
public class Deepseek_r1_distill_llama_70b {

    /**
     * This method performs a binary search on a sorted array to find the index of the target value.
     * 
     * @param array  The sorted array to search in.
     * @param target The value to search for.
     * @return The index of the target value if found; otherwise, -1.
     */
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential integer overflow

            // Check if target is present at mid
            if (array[mid] == target) {
                return mid;
            }
            // If target is in the left half
            else if (array[mid] > target) {
                high = mid - 1;
            }
            // If target is in the right half
            else {
                low = mid + 1;
            }
        }

        // If target is not found
        return -1;
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
        int result = Deepseek_r1_distill_llama_70b.binarySearch(array, target);

    }
}