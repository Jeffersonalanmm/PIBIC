import java.util.Random;
public class Llama_3_2_90b_vision_preview {

    /**
     * Searches for the specified element in the sorted array.
     *
     * @param array the sorted array to search in
     * @param target the element to search for
     * @return the index of the target element if found, -1 otherwise
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target element is at the mid index
            if (array[mid] == target) {
                return mid;
            }

            // If the target element is less than the mid element, move the right pointer
            if (array[mid] > target) {
                right = mid - 1;
            }

            // If the target element is greater than the mid element, move the left pointer
            else {
                left = mid + 1;
            }
        }

        // If the target element is not found, return -1
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
        int result = Llama_3_2_90b_vision_preview.binarySearch(array, target);
    }
}