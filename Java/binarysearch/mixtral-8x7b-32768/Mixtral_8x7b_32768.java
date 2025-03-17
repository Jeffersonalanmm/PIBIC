import java.util.Random;
public static int Mixtral_8x7b_32768(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
  
    // Continue searching while the left index is less than or equal to the right index
    while (left <= right) {
      int mid = left + (right - left) / 2;
  
      // If the middle element is the target, return its index
      if (arr[mid] == target) {
        return mid;
      }
  
      // If the middle element is less than the target, search the right half
      if (arr[mid] < target) {
        left = mid + 1;
      }
  
      // If the middle element is greater than the target, search the left half
      else {
        right = mid - 1;
      }
    }
  
    // If the target was not found, return -1
    return -1;

    public static void main(String[] args) {
        // Gerar 1000 valores aleatórios e ordená-los
        int[] arr = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);  // valores aleatórios entre 0 e 9999
        }

        // Ordenar o array para garantir que o algoritmo binário funcione corretamente
        java.util.Arrays.sort(arr);

        // Gerar um valor alvo aleatório para buscar no array
        int target = rand.nextInt(10000);  // valor aleatório entre 0 e 9999

        // Chamar a função Mixtral_8x7b_32768
        int result = Mixtral_8x7b_32768(arr, target);
    }
}