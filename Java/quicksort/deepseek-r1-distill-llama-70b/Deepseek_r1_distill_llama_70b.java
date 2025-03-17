import java.util.Random;
public class Deepseek_r1_distill_llama_70b {

    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = selectPivotMedianOfThree(array, low, high);
        swap(array, pivotIndex, high);
        int pivotFinalIndex = partition(array, low, high);
        quickSortHelper(array, low, pivotFinalIndex - 1);
        quickSortHelper(array, pivotFinalIndex + 1, high);
    }

    private static int selectPivotMedianOfThree(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        return mid;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 1000;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000) + 1; // Números entre 1 e 10000
        }

        // Ordenando com QuickSort
        quickSort(array);
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}