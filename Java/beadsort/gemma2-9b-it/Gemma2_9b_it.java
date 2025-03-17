import java.util.Random;
public class Gemma2_9b_it {

    public static void beadSort(int[] arr) {
        int max = getMax(arr);
        int numBeads = max + 1;

        // Create an array of beads, initially all empty
        boolean[] beads = new boolean[numBeads];

        // Place beads on the array based on the values in the input array
        for (int value : arr) {
            beads[value] = true;
        }

        // Iterate through the beads array and place values back into the input array
        int index = 0;
        for (int i = 0; i < numBeads; i++) {
            if (beads[i]) {
                arr[index++] = i;
            }
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[1000];

        // Preenchendo o array com valores aleatórios
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Números entre 0 e 999
        }
        // Ordenando com BeadSort
        Gemma2_9b_it.beadSort(array);
    }
}