import java.util.Random;
public class Mixtral_8x7b_32768 {
    public static void beadSort(int[] arr) {
        // Find the maximum value in the array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create an array of "beads" with length equal to the maximum value
        // plus one (to account for the 0 index)
        int[] beads = new int[max + 1];

        // Place the beads in the array according to the values in the input array
        for (int i = 0; i < arr.length; i++) {
            beads[arr[i]] = 1;
        }

        // Iterate through the beads array, placing the values in the output array
        // as we go
        int index = 0;
        for (int i = 0; i < beads.length; i++) {
            if (beads[i] == 1) {
                arr[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];

        // Preenchendo o array com valores aleatórios
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Números entre 0 e 999
        }

        // Ordenando com BeadSort
        Mixtral_8x7b_32768.beadSort(array);
    }
}