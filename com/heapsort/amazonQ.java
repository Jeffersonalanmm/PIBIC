import java.util.Arrays;

public class amazonQ {

  public static void sort(int[] array) {

    int n = array.length;

    // Build max heap
    for(int i = n/2 - 1; i >= 0; i--) {
      heapify(array, n, i);
    }

    // Heap sort
    for(int i=n-1; i>=0; i--) {
      int temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      heapify(array, i, 0);
    }
  }

  public static void heapify(int[] arr, int n, int i) {
    int largest = i; 
    int l = 2*i + 1; 
    int r = 2*i + 2; 

    if (l < n && arr[l] > arr[largest])
      largest = l;

    if (r < n && arr[r] > arr[largest])
      largest = r;

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest);
    }
  }

  public static void main(String[] args) {
    int[] array = {12, 11, 13, 5, 6, 7};
    sort(array);
    System.out.println(Arrays.toString(array)); 
  }

}
