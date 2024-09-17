public class AmazonQ {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Example usage
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[1000];
        
        // Generate 1000 random values
        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(1000); // Random value between 0 and 999
        }

        AmazonQ quickSort = new AmazonQ();
        quickSort.sort(arr);
    }
}
