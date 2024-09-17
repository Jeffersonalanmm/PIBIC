public class Gemini {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high]
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
  
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[1000];
        
        // Generate 1000 random values
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(1000); // Random value between 0 and 999
        }

        // Sort the array
        quickSort(array, 0, array.length - 1);
    }

}